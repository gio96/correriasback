package com.ceiba.application.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {

    private String nombreProducto;
    private int cantidad;
    private int valorUnitario;
}
