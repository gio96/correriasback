package com.ceiba.infraestructura.testdatabuilder;

import com.ceiba.application.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private String nombreProducto;
    private int cantidad;
    private int valorUnitario;

    public ComandoProductoTestDataBuilder() {
        this.nombreProducto = "Collar";
        this.cantidad = 2;
        this.valorUnitario = 800;
    }

    public ComandoProductoTestDataBuilder conNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
        return this;
    }

    public ComandoProductoTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ComandoProductoTestDataBuilder conValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
        return this;
    }

    public ComandoProducto build() {
        return ComandoProducto.builder()
                .nombreProducto(this.nombreProducto)
                .cantidad(this.cantidad)
                .valorUnitario(this.valorUnitario).build();
    }
}
