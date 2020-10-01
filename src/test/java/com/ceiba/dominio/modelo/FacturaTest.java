package com.ceiba.dominio.modelo;

import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.modelo.entidad.Producto;
import com.ceiba.dominio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FacturaTest {


    private static final String nombreProducto = "nombreProductoTest";
    private static final int cantidad = 2;
    private static final int valorUnitario = 300;
    private static final String id = "id";
    private static final String idCliente = "idCliente";
    private static final double descuentoFactura = 3;
    private static final Date fechaGenerada = new Date();
    private static final double totalFactura = 200;

    @Test
    public void crearFactura() {

        // arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conNombreProducto(nombreProducto)
                .conCantidad(cantidad)
                .conValorUnitario(valorUnitario);

        FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder()
                .conId(id)
                .conIdCliente(idCliente)
                .conDescuentoFactura(descuentoFactura)
                .conProductos(Collections.singletonList(productoTestDataBuilder.build()))
                .conFechaGenerada(fechaGenerada)
                .conTotalFactura(totalFactura);

        //act
        Factura factura = facturaTestDataBuilder.build();


        //assert
        assertEquals(nombreProducto, factura.getProductos().get(0).getNombreProducto());
        assertEquals(cantidad, factura.getProductos().get(0).getCantidad());
        assertEquals(valorUnitario, factura.getProductos().get(0).getValorUnitario());
        assertEquals(id, factura.getId());
        assertEquals(idCliente, factura.getIdCliente());
        assertEquals(descuentoFactura, factura.getDescuentoFactura(), 0);
        assertEquals(fechaGenerada, factura.getFechaGenerada());
        assertEquals(totalFactura, factura.getTotalFactura(), 0);


    }
}
