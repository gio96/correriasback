package com.ceiba.infraestructura.adaptador.dao;

import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.adaptador.data.ClienteData;
import com.ceiba.infraestructura.adaptador.mongodb.ClienteRepositoryDataAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RepositorioClienteMongo implements RepositorioCliente {

    private final ClienteRepositoryDataAdapter clienteRepositoryDataAdapter;

    @Override
    public Collection<DtoCliente> listaClientes() {
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

    private DtoCliente clienteDataToCliente(ClienteData clienteData) {
        return DtoCliente.builder()
                .id(clienteData.getId())
                .nombreCompleto(clienteData.getNombreCompleto())
                .telefono(clienteData.getTelefono())
                .ciudad(clienteData.getCiudad())
                .correoCliente(clienteData.getCorreoCliente())
                .build();
    }
}
