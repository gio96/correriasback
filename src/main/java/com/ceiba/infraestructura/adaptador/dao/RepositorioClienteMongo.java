package com.ceiba.infraestructura.adaptador.dao;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.adaptador.data.ClienteData;
import com.ceiba.infraestructura.adaptador.mongodb.ClienteRepositoryDataAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RepositorioClienteMongo implements RepositorioCliente {

    private final ClienteRepositoryDataAdapter clienteRepositoryDataAdapter;

    @Override
    public Collection<Cliente> listaClientes() {
        return clienteRepositoryDataAdapter.findAll().stream()
                .map(this::clienteDataToCliente)
                .collect(Collectors.toList());
    }

    @Override
    public void crearCliente(Cliente cliente) {
        ClienteData clienteData = ClienteData
                .builder()
                .nombreCompleto(cliente.getNombreCompleto())
                .ciudad(cliente.getCiudad())
                .telefono(cliente.getTelefono())
                .correoCliente(cliente.getCorreoCliente())
                .build();
        clienteRepositoryDataAdapter.save(clienteData);
    }

    @Override
    public Optional<Cliente> obtenerCliente(String idCliente) {
        return clienteRepositoryDataAdapter.findById(idCliente)
                .map(this::clienteDataToCliente);
    }

    private Cliente clienteDataToCliente(ClienteData clienteData) {
        return new Cliente(clienteData.getId(), clienteData.getNombreCompleto(),
                clienteData.getCiudad(), clienteData.getTelefono(), clienteData.getCorreoCliente());
    }
}
