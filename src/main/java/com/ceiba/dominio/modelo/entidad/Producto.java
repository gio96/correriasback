package com.ceiba.dominio.modelo.entidad;

public class Producto {

    private final String nombreProducto;
    private final int cantidad;
    private final int valorUnitario;

    public Producto(String nombreProducto, int cantidad, int valorUnitario) {
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.valorUnitario = valorUnitario;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }
}
