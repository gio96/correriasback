package com.ceiba.dominio.utils;

import com.ceiba.dominio.excepcion.FacturaException;
import com.ceiba.dominio.modelo.dto.DtoDescuentoFactura;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import static com.ceiba.dominio.utils.FacturaUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FacturaUtilsTest {


    private Factura factura;
    private ProductoTestDataBuilder productoTestDataBuilder;

    @Before
    public void init() {
        productoTestDataBuilder = new ProductoTestDataBuilder()
                .conNombreProducto("nombreProducto")
                .conCantidad(2)
                .conValorUnitario(300);

        FacturaTestDataBuilder facturaTestDataBuilder = new FacturaTestDataBuilder()
                .conId("id")
                .conIdCliente("idCliente")
                .conDescuentoFactura(3)
                .conProductos(Collections.singletonList(productoTestDataBuilder.build()))
                .conFechaGenerada(new Date());

        factura = facturaTestDataBuilder.build();
    }

    @Test
    public void validarDiaNoVentasTestException() {
        // arrange
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);

        try {
            //act
            validarDiaNoVentas(diaActual, diaActual, Calendar.SATURDAY);
            fail();
        } catch (FacturaException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(FacturaException.Type.NO_VENDER.getMessage()));
        }

    }

    @Test
    public void calcularTotalFacturaTest() {
        //act
        double totalFactura = calcularTotalFactura(Collections.singletonList(productoTestDataBuilder.build()), 3);

        //assert
        assertEquals(582, totalFactura, 0);

    }

    @Test
    public void calcularTotalFacturaTestProductosVacio() {
        //act
        double totalFactura = calcularTotalFactura(Collections.emptyList(), 3);

        //assert
        assertEquals(0, totalFactura, 0);

    }

    @Test
    public void calcularTotalFacturaTestDescuento0() {
        //act
        double totalFactura = calcularTotalFactura(Collections.singletonList(productoTestDataBuilder.build()), 0);

        //assert
        assertEquals(600, totalFactura, 0);

    }

    @Test
    public void calcularTotalFacturaDescuentoAdicionalTestSinDiaEspecial(){
        // arrange
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);

        DtoDescuentoFactura dtoDescuentoFactura = DtoDescuentoFactura.builder()
                .factura(factura)
                .diaActual(diaActual)
                .valorASuperar(200000)
                .diaEspecial(diaActual+1)
                .descuentoAdicional(3).build();

        //act
        double totalFactura = calcularTotalFacturaDescuentoAdicional(dtoDescuentoFactura);


        //assert
        assertEquals(582, totalFactura, 0);
    }

    @Test
    public void calcularTotalFacturaDescuentoAdicionalTestConDiaEspecial(){
        // arrange
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);

        DtoDescuentoFactura dtoDescuentoFactura = DtoDescuentoFactura.builder()
                .factura(factura)
                .diaActual(diaActual)
                .valorASuperar(200000)
                .diaEspecial(diaActual)
                .descuentoAdicional(3).build();

        //act
        double totalFactura = calcularTotalFacturaDescuentoAdicional(dtoDescuentoFactura);


        //assert
        assertEquals(564.54, totalFactura, 0);
    }
}
