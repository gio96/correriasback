package com.ceiba.dominio.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class Factura {

    private final String id;
    private final String idCliente;
    private final double descuentoFactura;
    private final List<Producto> productos;
    private final Date fechaGenerada;
    private final double totalFactura;
}
