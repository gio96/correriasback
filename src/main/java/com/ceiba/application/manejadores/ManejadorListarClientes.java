package com.ceiba.application.manejadores;


import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ManejadorListarClientes {

    private final ServicioObtenerCliente servicioObtenerCliente;

    @Transactional
    public Collection<DtoCliente> ejecutar() {
        return servicioObtenerCliente.ejecutar();
    }
}
