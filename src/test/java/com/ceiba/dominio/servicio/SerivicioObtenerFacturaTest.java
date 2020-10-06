package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import com.ceiba.dominio.servicio.factura.ServicioObtenerFactura;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.testdatabuilder.FacturaTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SerivicioObtenerFacturaTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @Mock
    private RepositorioFactura repositorioFactura;

    @InjectMocks
    private ServicioObtenerFactura servicioObtenerFactura;

    @Test
    public void validarClientesNoNulo() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        Factura factura = new FacturaTestDataBuilder().build();

        //act
        Mockito.when(repositorioCliente.obtenerCliente(Mockito.anyString()))
                .thenReturn(Optional.of(cliente));

        Mockito.when(repositorioFactura.listarFacturas(Mockito.anyString()))
                .thenReturn(Collections.singletonList(factura));

        //assert
        assertEquals(factura.getIdCliente(), servicioObtenerFactura.ejecutar("id").get(0).getIdCliente());

        verify(repositorioCliente, times(1)).obtenerCliente(anyString());
        verify(repositorioFactura, times(1)).listarFacturas(anyString());

    }
}
