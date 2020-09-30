package com.ceiba.dominio.servicio.factura;

import com.ceiba.dominio.excepcion.FacturaException;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.modelo.entidad.Producto;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import lombok.RequiredArgsConstructor;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class ServicioCrearFactura {
    private final RepositorioFactura repositorioFactura;

    //TODO validar existencia cliente;
    //TODO el descuento sumado es sobre el total o sobre la base en el momento
    public void ejecutar(Factura factura) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);
        manejarDiaNoVentas(diaActual, Calendar.SUNDAY, Calendar.SATURDAY);

        double totalFactura = calcularTotalFacturaDescuentoAdicional(factura, diaActual, 200000);

        Factura facturaCalculada = Factura.builder()
                .idCliente(factura.getIdCliente())
                .descuentoFactura(factura.getDescuentoFactura())
                .productos(factura.getProductos())
                .fechaGenerada(factura.getFechaGenerada())
                .totalFactura(totalFactura)
                .build();

        repositorioFactura.crearFactura(facturaCalculada);
    }

    public double calcularTotalFacturaDescuentoAdicional(Factura factura, int diaActual, int valorASuperar) {
        int descuentoAdicional = 2;
        double totalFactura = calcularTotalFactura(factura.getProductos(), factura.getDescuentoFactura());

        if (totalFactura > valorASuperar || diaActual == Calendar.WEDNESDAY) {
            totalFactura = totalFactura - (totalFactura * descuentoAdicional / 100);
        }

        return totalFactura;
    }

    public void manejarDiaNoVentas(int diaActual, int diaNoVenta1, int diaNoVenta2) {
        if (diaActual == diaNoVenta1 || diaActual == diaNoVenta2) {
            throw FacturaException.Type.NO_VENDER.build();
        }
    }

    public double calcularTotalFactura(List<Producto> productoList, double descuento) {
        int sumaFactura = productoList.stream()
                .mapToInt(value -> value.getCantidad() * value.getValorUnitario())
                .sum();

        if (descuento == 0) {
            return sumaFactura;
        }

        return sumaFactura - (sumaFactura * descuento / 100);
    }
}
