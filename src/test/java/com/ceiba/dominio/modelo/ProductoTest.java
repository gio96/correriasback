package com.ceiba.dominio.modelo;

import com.ceiba.dominio.modelo.entidad.Producto;
import com.ceiba.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductoTest {


    private static final String nombreProducto = "nombreProductoTest";
    private static final int cantidad = 2;
    private static final int valorUnitario = 300;

    @Test
    public void crearProducto() {

        // arrange
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
                .conNombreProducto(nombreProducto)
                .conCantidad(cantidad)
                .conValorUnitario(valorUnitario);

        //act
        Producto producto = productoTestDataBuilder.build();

        //assert
        assertEquals(nombreProducto, producto.getNombreProducto());
        assertEquals(cantidad, producto.getCantidad());
        assertEquals(valorUnitario, producto.getValorUnitario());


    }
}
