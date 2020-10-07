package com.ceiba.dominio.testdatabuilder;

import com.ceiba.dominio.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private String nombreProducto;
    private int cantidad;
    private int valorUnitario;

    public ProductoTestDataBuilder() {
        this.nombreProducto = "Collar";
        this.cantidad = 2;
        this.valorUnitario = 800;
    }

    public ProductoTestDataBuilder conNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
        return this;
    }

    public ProductoTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ProductoTestDataBuilder conValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public Producto build() {
        return new Producto(this.nombreProducto, this.cantidad, this.valorUnitario);
    }
}
