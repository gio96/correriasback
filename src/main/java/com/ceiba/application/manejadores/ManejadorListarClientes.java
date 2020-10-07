package com.ceiba.application.manejadores;


import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerListaClientes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class ManejadorListarClientes {

    private final ServicioObtenerListaClientes servicioObtenerListaClientes;

    @Transactional
    public Collection<Cliente> ejecutar() {
        return servicioObtenerListaClientes.ejecutar();
    }
}
