package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.utils.StringUtils;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioCrearCliente {
    private final RepositorioCliente repositorioCliente;

    public void ejecutar(Cliente cliente) {
        StringUtils.validarObligatorio(cliente.getNombreCompleto());
        repositorioCliente.crearCliente(cliente);
    }
}
