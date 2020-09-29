package com.ceiba.dominio.servicio.factura;

import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ServicioCrearFactura {
    private final RepositorioFactura repositorioFactura;

    public void ejecutar(Factura factura) {
        repositorioFactura.crearFactura(factura);
    }
}
