package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

public class ServicioObtenerListaClientes {
    private final RepositorioCliente repositorioCliente;

    public ServicioObtenerListaClientes(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Collection<DtoCliente> ejecutar() {
        return this.repositorioCliente.listaClientes();
    }
}
