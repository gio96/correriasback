package com.ceiba.dominio.servicio.cliente;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import lombok.RequiredArgsConstructor;

import static com.ceiba.dominio.utils.StringUtils.validarObligatorios;


public class ServicioCrearCliente {

    private final RepositorioCliente repositorioCliente;

    public ServicioCrearCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        String[] valoresAValidar = {cliente.getNombreCompleto(), cliente.getCiudad(),
                cliente.getCorreoCliente(), cliente.getTelefono()};
        validarObligatorios(valoresAValidar);
        this.repositorioCliente.crearCliente(cliente);
    }
}
