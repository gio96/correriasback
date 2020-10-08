package com.ceiba.infraestructura.adaptador.dao;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.infraestructura.adaptador.data.ClienteData;
import com.ceiba.infraestructura.adaptador.data.ClienteH;
import com.ceiba.infraestructura.adaptador.mongodb.ClienteRepositoryDataAdapter;
import com.ceiba.infraestructura.adaptador.mysql.ClienteRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class RepositorioClienteMongo implements RepositorioCliente {

    private final ClienteRepositoryDataAdapter clienteRepositoryDataAdapter;
    private final ClienteRepositoryAdapter clienteRepositoryAdapter;

    @Override
    public Collection<Cliente> listaClientes() {
        return StreamSupport.stream(clienteRepositoryAdapter.findAll().spliterator(), false)
                .map(this::clienteDataToCliente)
                .collect(Collectors.toList());
        //return clienteRepositoryDataAdapter.findAll().stream()
        //        .map(this::clienteDataToCliente)
        //        .collect(Collectors.toList());
    }

    @Override
    public void crearCliente(Cliente cliente) {
       ClienteH clienteData  = new ClienteH(cliente.getNombreCompleto(),cliente.getCiudad(),cliente.getTelefono(),cliente.getCorreoCliente());
        clienteRepositoryAdapter.save(clienteData);
    }

    @Override
    public Optional<Cliente> obtenerCliente(String idCliente) {
        //return clienteRepositoryDataAdapter.findById(idCliente)
        //        .map(this::clienteDataToCliente);

        return Optional.empty();
    }

    private Cliente clienteDataToCliente(ClienteH clienteData) {
        return new Cliente(String.valueOf(clienteData.getId()), clienteData.getNombreCompleto(),
                clienteData.getCiudad(), clienteData.getTelefono(), clienteData.getCorreoCliente());
    }
}
