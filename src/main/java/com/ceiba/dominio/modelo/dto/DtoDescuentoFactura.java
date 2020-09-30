package com.ceiba.dominio.modelo.dto;

import com.ceiba.dominio.modelo.entidad.Factura;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder(toBuilder = true)
public class DtoDescuentoFactura {

    @NonNull
    private final Factura factura;
    @NonNull
    private final int diaActual;
    @NonNull
    private final int valorASuperar;
    @NonNull
    private final int diaEspecial;
    @NonNull
    private final int descuentoAdicional;
}
