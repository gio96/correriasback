package com.ceiba.application.comando;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class ComandoFactura {
    private String id;
    private double descuentoFactura;
    private List<ComandoProducto> productos;
    private Date fechaGenerada;
}
