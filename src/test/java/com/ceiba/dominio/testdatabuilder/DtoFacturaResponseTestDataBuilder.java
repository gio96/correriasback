package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.dto.DtoFacturaResponse;
import com.ceiba.dominio.modelo.entidad.Producto;

import java.util.ArrayList;
import java.util.List;

public class DtoFacturaResponseTestDataBuilder {

    private String id;
    private String idCliente;
    private double descuentoFactura;
    private List<Producto> productos;
    private String fechaGenerada;
    private double totalFactura;

    public DtoFacturaResponseTestDataBuilder() {
        this.id = "id";
        this.idCliente = "idCliente";
        this.descuentoFactura = 3;
        this.productos = new ArrayList<Producto>();
        this.fechaGenerada = "Octubre 02 2020";
        this.totalFactura = 5000;
    }

    public DtoFacturaResponseTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public DtoFacturaResponseTestDataBuilder conIdCliente(String idCliente) {
        this.idCliente = idCliente;
        return this;
    }

    public DtoFacturaResponseTestDataBuilder conDescuentoFactura(double descuentoFactura) {
        this.descuentoFactura = descuentoFactura;
        return this;
    }

    public DtoFacturaResponseTestDataBuilder conProductos(List<Producto> productos) {
        this.productos = productos;
        return this;
    }

    public DtoFacturaResponseTestDataBuilder conFechaGenerada(String fechaGenerada) {
        this.fechaGenerada = fechaGenerada;
        return this;
    }

    public DtoFacturaResponseTestDataBuilder conTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
        return this;
    }

    public DtoFacturaResponse build() {
        return DtoFacturaResponse.builder()
                .id(this.id)
                .idCliente(this.idCliente)
                .descuentoFactura(this.descuentoFactura)
                .fechaGenerada(this.fechaGenerada)
                .productos(this.productos)
                .totalFactura(this.totalFactura)
                .build();
    }
}


