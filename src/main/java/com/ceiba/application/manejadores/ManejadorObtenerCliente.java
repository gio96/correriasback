package com.ceiba.application.manejadores;


import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ManejadorObtenerCliente {

    private final ServicioObtenerCliente servicioObtenerCliente;

    @Transactional
    public Cliente ejecutar(String idCliente) {
        return servicioObtenerCliente.ejecutar(idCliente);
    }
}
