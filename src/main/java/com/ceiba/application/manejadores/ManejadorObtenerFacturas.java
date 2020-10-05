package com.ceiba.application.manejadores;


import com.ceiba.dominio.modelo.dto.DtoFacturaResponse;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.servicio.factura.ServicioObtenerFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ManejadorObtenerFacturas {

    private final ServicioObtenerFactura servicioObtenerFactura;

    @Transactional
    public List<DtoFacturaResponse> ejecutar(String idCliente) {
        return servicioObtenerFactura.ejecutar(idCliente);
    }
}
