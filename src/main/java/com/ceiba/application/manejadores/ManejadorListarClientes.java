package com.ceiba.application.manejadores;


import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ManejadorListarClientes {

    private final ServicioObtenerCliente servicioObtenerCliente;

    public Collection<DtoCliente> ejecutar() {
        return servicioObtenerCliente.ejecutar();
    }
}
