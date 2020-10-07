package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.modelo.entidad.Producto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacturaTestDataBuilder {

    private String id;
    private String idCliente;
    private double descuentoFactura;
    private List<Producto> productos;
    private Date fechaGenerada;
    private double totalFactura;

    public FacturaTestDataBuilder() {
        this.id = "id";
        this.idCliente = "idCliente";
        this.descuentoFactura = 3;
        this.productos = new ArrayList<Producto>();
        this.fechaGenerada = new Date();
        this.totalFactura = 5000;
    }

    public FacturaTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public FacturaTestDataBuilder conIdCliente(String idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public FacturaTestDataBuilder conDescuentoFactura(double descuentoFactura) {
        this.descuentoFactura = descuentoFactura;
        return this;
    }

    public FacturaTestDataBuilder conProductos(List<Producto> productos) {
        this.productos = productos;
        return this;
    }

    public FacturaTestDataBuilder conFechaGenerada(Date fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
        return this;
    }

    public FacturaTestDataBuilder conTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
        return this;
    }

    public Factura build() {
        return new Factura(this.id, this.idCliente, this.descuentoFactura, this.productos, this.fechaGenerada, this.totalFactura);
    }
}


