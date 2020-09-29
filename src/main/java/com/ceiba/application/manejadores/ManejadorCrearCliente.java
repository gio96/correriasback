package com.ceiba.application.manejadores;


import com.ceiba.application.comando.ComandoCliente;
import com.ceiba.application.fabrica.FabricaCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.servicio.cliente.ServicioCrearCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ManejadorCrearCliente {

    private final ServicioCrearCliente servicioCrearCliente;
    private final FabricaCliente fabricaCliente;

    public void ejecutar(ComandoCliente comandoCliente) {
        Cliente cliente = fabricaCliente.crearCliente(comandoCliente);
        servicioCrearCliente.ejecutar(cliente);
    }
}
