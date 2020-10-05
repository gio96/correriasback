package com.ceiba.dominio.modelo.dto;

import com.ceiba.dominio.modelo.entidad.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
public class DtoFacturaResponse {

    private final String id;
    private final String idCliente;
    private final double descuentoFactura;
    private final List<Producto> productos;
    private final String fechaGenerada;
    private final double totalFactura;
}
