package com.ceiba.application.comando;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder(toBuilder = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class ComandoFactura {
    private final String id;
    private final double descuentoFactura;
    private final List<ComandoProducto> productos;
    private final Date fechaGenerada;
}
