package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

import static com.ceiba.dominio.utils.StringUtils.isEmpty;
import static com.ceiba.dominio.utils.StringUtils.validarObligatorio;

@RequiredArgsConstructor
public class ServicioCrearCliente {
    private final RepositorioCliente repositorioCliente;

    public void ejecutar(Cliente cliente) {
        String[] valoresAValidar = {cliente.getNombreCompleto(), cliente.getCiudad(),
                cliente.getCorreoCliente(), cliente.getTelefono()};
        isEmpty(valoresAValidar);
        validarObligatorio(cliente.getNombreCompleto());
        repositorioCliente.crearCliente(cliente);
    }
}
