package com.ceiba.application.manejadores;


import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.fabrica.FabricaFactura;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.servicio.factura.ServicioCrearFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ManejadorCrearFactura {

    private final ServicioCrearFactura servicioCrearFactura;
    private final FabricaFactura fabricaFactura;

    @Transactional
    public void ejecutar(String idCliente, ComandoFactura comandoFactura) {
        Factura factura = fabricaFactura.crearFactura(comandoFactura);
        servicioCrearFactura.ejecutar(idCliente, factura);
    }
}
