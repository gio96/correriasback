package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;

import java.util.Collection;

public class ServicioObtenerListaClientes {
    private final RepositorioCliente repositorioCliente;

    public ServicioObtenerListaClientes(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public Collection<Cliente> ejecutar() {
        return this.repositorioCliente.listaClientes();
    }
}
