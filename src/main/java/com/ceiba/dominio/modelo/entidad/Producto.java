package com.ceiba.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Producto {

    private final String nombreProducto;
    private final int cantidad;
    private final int valorUnitario;
}
