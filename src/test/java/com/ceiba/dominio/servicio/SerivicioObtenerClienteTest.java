package com.ceiba.dominio.servicio;

import com.ceiba.dominio.excepcion.ClienteException;
import com.ceiba.dominio.excepcion.FacturaException;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Calendar;
import java.util.Optional;

import static com.ceiba.dominio.utils.FacturaUtils.validarDiaNoVentas;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SerivicioObtenerClienteTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioObtenerCliente servicioObtenerCliente;

    @Test
    public void validarClientesNoNulo() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();

        //act
        Mockito.when(repositorioCliente.obtenerCliente(Mockito.anyString()))
                .thenReturn(Optional.of(cliente));

        //assert
        assertEquals(cliente, servicioObtenerCliente.ejecutar("id"));

        verify(repositorioCliente, times(1)).obtenerCliente(anyString());

    }

    @Test
    public void validarClientesOptionalVacio() {

        //act
        Mockito.when(repositorioCliente.obtenerCliente(Mockito.anyString()))
                .thenReturn(Optional.empty());

        try {
            //act
            servicioObtenerCliente.ejecutar("id");
            fail();
        } catch (ClienteException ex) {
            //assert
            assertThat(ex.getMessage(),
                    Matchers.is(ClienteException.Type.CLIENTE_NOT_FOUND.getMessage()));
        }

        verify(repositorioCliente, times(1)).obtenerCliente(anyString());

    }
}
