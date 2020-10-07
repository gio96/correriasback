package com.ceiba.dominio.modelo.dto;

import com.ceiba.dominio.modelo.entidad.Factura;

public class DtoDescuentoFactura {

    private final Factura factura;
    
    private final int diaActual;
    
    private final int valorASuperar;
    
    private final int diaEspecial;
    
    private final int descuentoAdicional;

    public DtoDescuentoFactura(Factura factura, int diaActual, int valorASuperar, int diaEspecial, int descuentoAdicional) {
        this.factura = factura;
        this.diaActual = diaActual;
        this.valorASuperar = valorASuperar;
        this.diaEspecial = diaEspecial;
        this.descuentoAdicional = descuentoAdicional;
    }

    public Factura getFactura() {
        return factura;
    }

    public int getDiaActual() {
        return diaActual;
    }

    public int getValorASuperar() {
        return valorASuperar;
    }

    public int getDiaEspecial() {
        return diaEspecial;
    }

    public int getDescuentoAdicional() {
        return descuentoAdicional;
    }
}
