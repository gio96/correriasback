package com.ceiba.infraestructura.testdatabuilder;

import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.comando.ComandoProducto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class ComandoFacturaTestDataBuilder {

    private String id;
    private double descuentoFactura;
    private List<ComandoProducto> productos;
    private Date fechaGenerada;

    public ComandoFacturaTestDataBuilder() {
        ComandoProductoTestDataBuilder comandoProductoTestDataBuilder = new ComandoProductoTestDataBuilder();
        this.id = "id";
        this.descuentoFactura = 3;
        this.productos = Collections.singletonList(comandoProductoTestDataBuilder.build());
        this.fechaGenerada = new Date();
    }

    public ComandoFacturaTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public ComandoFacturaTestDataBuilder conDescuentoFactura(double descuentoFactura) {
        this.descuentoFactura = descuentoFactura;
        return this;
    }

    public ComandoFacturaTestDataBuilder conProductos(List<ComandoProducto> productos) {
        this.productos = productos;
        return this;
    }

    public ComandoFacturaTestDataBuilder conFechaGenerada(Date fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
        return this;
    }

    public ComandoFactura build() {
        return ComandoFactura.builder()
                .id(this.id)
                .descuentoFactura(this.descuentoFactura)
                .fechaGenerada(this.fechaGenerada)
                .productos(this.productos)
                .build();
    }
}


