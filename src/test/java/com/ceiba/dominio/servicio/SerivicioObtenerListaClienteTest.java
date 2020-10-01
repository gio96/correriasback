package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerListaClientes;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SerivicioObtenerListaClienteTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioObtenerListaClientes servicioObtenerListaClientes;

    @Test
    public void validarClientesNoNulo() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();

        //act
        Mockito.when(repositorioCliente.listaClientes())
                .thenReturn(Collections.singleton(DtoCliente.builder()
                        .nombreCompleto(cliente.getNombreCompleto()).build()));

        //assert
        assertEquals(1L, servicioObtenerListaClientes.ejecutar().size());

        verify(repositorioCliente, times(1)).listaClientes();

    }
}
