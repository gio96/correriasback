package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

import java.util.Collection;

@RequiredArgsConstructor
public class ServicioObtenerListaClientes {
    private final RepositorioCliente repositorioCliente;

    public Collection<DtoCliente> ejecutar() {
        return repositorioCliente.listaClientes();
    }
}
