package com.ceiba.application.fabrica;

import com.ceiba.application.comando.ComandoCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {
    public Cliente crearCliente(ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getId(), comandoCliente.getNombreCompleto(),
                comandoCliente.getCiudad(), comandoCliente.getTelefono(), comandoCliente.getCorreoCliente());
        /*return Cliente.builder()
                .id(comandoCliente.getId())
                .nombreCompleto(comandoCliente.getNombreCompleto())
                .ciudad(comandoCliente.getCiudad())
                .telefono(comandoCliente.getTelefono())
                .correoCliente(comandoCliente.getCorreoCliente())
                .build();*/
    }
}
