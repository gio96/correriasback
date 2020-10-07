package com.ceiba.dominio.modelo.entidad;

import java.util.Date;
import java.util.List;

public class Factura {

    private String id;
    private String idCliente;
    private double descuentoFactura;
    private List<Producto> productos;
    private Date fechaGenerada;
    private double totalFactura;

    public Factura(String idCliente, double descuentoFactura, List<Producto> productos, Date fechaGenerada, double totalFactura) {
        this.idCliente = idCliente;
        this.descuentoFactura = descuentoFactura;
        this.productos = productos;
        this.fechaGenerada = fechaGenerada;
        this.totalFactura = totalFactura;
    }

    public Factura(double descuentoFactura, List<Producto> productos, Date fechaGenerada) {
        this.descuentoFactura = descuentoFactura;
        this.productos = productos;
        this.fechaGenerada = fechaGenerada;
    }

    public Factura(String id, String idCliente, double descuentoFactura, List<Producto> productos, Date fechaGenerada, double totalFactura) {
        this.id = id;
        this.idCliente = idCliente;
        this.descuentoFactura = descuentoFactura;
        this.productos = productos;
        this.fechaGenerada = fechaGenerada;
        this.totalFactura = totalFactura;
    }

    public String getId() {
        return id;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public double getDescuentoFactura() {
        return descuentoFactura;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public Date getFechaGenerada() {
        return fechaGenerada;
    }

    public double getTotalFactura() {
        return totalFactura;
    }
}
