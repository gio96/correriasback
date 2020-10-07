package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.excepcion.ClienteException;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

import java.util.Objects;


public class ServicioObtenerCliente {
    private final RepositorioCliente repositorioCliente;

    public ServicioObtenerCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Cliente ejecutar(String idCliente) {
        return this.repositorioCliente.obtenerCliente(idCliente)
                .filter(cliente -> Objects.nonNull(cliente.getId()))
                .orElseThrow(ClienteException.Type.CLIENTE_NOT_FOUND::build);
    }
}
