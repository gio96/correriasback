package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioCrearCliente {
    private final RepositorioCliente repositorioCliente;

    public void ejecutar(Cliente cliente) {
        repositorioCliente.crearCliente(cliente);
    }
}
