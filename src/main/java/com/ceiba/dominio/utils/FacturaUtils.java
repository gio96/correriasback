package com.ceiba.dominio.utils;

import com.ceiba.dominio.excepcion.FacturaException;
import com.ceiba.dominio.modelo.dto.DtoDescuentoFactura;
import com.ceiba.dominio.modelo.entidad.Producto;

import java.util.List;

public class FacturaUtils {

    public static double calcularTotalFacturaDescuentoAdicional(DtoDescuentoFactura dtoDescuentoFactura) {
        double totalFactura = calcularTotalFactura(dtoDescuentoFactura.getFactura().getProductos(), dtoDescuentoFactura.getFactura().getDescuentoFactura());

        if (totalFactura > dtoDescuentoFactura.getValorASuperar() ||
                dtoDescuentoFactura.getDiaActual() == dtoDescuentoFactura.getDiaEspecial()) {
            totalFactura = totalFactura - (totalFactura * dtoDescuentoFactura.getDescuentoAdicional() / 100);
        }

        return totalFactura;
    }

    public static double calcularTotalFactura(List<Producto> productoList, double descuento) {
        int sumaFactura = productoList.stream()
                .mapToInt(value -> value.getCantidad() * value.getValorUnitario())
                .sum();

        if (descuento == 0) {
            return sumaFactura;
        }

        return sumaFactura - (sumaFactura * descuento / 100);
    }

    public static void validarDiaNoVentas(int diaActual, int diaNoVenta1, int diaNoVenta2) {
        if (diaActual == diaNoVenta1 || diaActual == diaNoVenta2) {
            throw FacturaException.Type.NO_VENDER.build();
        }
    }

}
