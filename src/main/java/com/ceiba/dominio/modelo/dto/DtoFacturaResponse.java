package com.ceiba.dominio.modelo.dto;

import com.ceiba.dominio.modelo.entidad.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

public class DtoFacturaResponse {

    private final String id;
    private final String idCliente;
    private final double descuentoFactura;
    private final List<Producto> productos;
    private final String fechaGenerada;
    private final double totalFactura;

    public DtoFacturaResponse(String id, String idCliente, double descuentoFactura, List<Producto> productos, String fechaGenerada, double totalFactura) {
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

    public String getFechaGenerada() {
        return fechaGenerada;
    }

    public double getTotalFactura() {
        return totalFactura;
    }
}
