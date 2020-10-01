package com.ceiba.dominio.servicio;

import com.ceiba.dominio.excepcion.ClienteException;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import com.ceiba.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.FacturaTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.ProductoTestDataBuilder;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class ServicioCrearFacturaTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @Mock
    private RepositorioFactura repositorioFactura;

    @InjectMocks
    private ServicioCrearFactura servicioCrearFactura;

    private Factura factura;

    @Before
    public void init() {
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder()
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
    public void validarClientesOptionalVacio() {

        //act
        Mockito.when(repositorioCliente.obtenerCliente(Mockito.anyString()))
                .thenReturn(Optional.empty());

        try {
            //act
            servicioCrearFactura.ejecutar("id", factura);
            fail();
        } catch (ClienteException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(ClienteException.Type.CLIENTE_NOT_FOUND.getMessage()));
        }

        verify(repositorioCliente, times(1)).obtenerCliente(anyString());

    }

    @Test
    public void validarClientesNoNulo() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();

        //act
        Mockito.when(repositorioCliente.obtenerCliente(Mockito.anyString()))
                .thenReturn(Optional.of(cliente));


        servicioCrearFactura.ejecutar("id", factura);


        //assert
        verify(repositorioCliente, times(1)).obtenerCliente(anyString());
        verify(repositorioFactura, times(1)).crearFactura(any(Factura.class));

    }
}
