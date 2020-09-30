package com.ceiba.application.comando;

import lombok.*;

@Getter
@Builder(toBuilder = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class ComandoProducto {

    private final String nombreProducto;
    private final int cantidad;
    private final int valorUnitario;
}
