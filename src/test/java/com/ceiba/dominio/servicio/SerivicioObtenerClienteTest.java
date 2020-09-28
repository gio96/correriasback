package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class SerivicioObtenerClienteTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioObtenerCliente servicioObtenerCliente;

    @Test
    public void validarClientesNoNulo() {
        Cliente cliente = new ClienteTestDataBuilder().build();

        Mockito.when(repositorioCliente.listaClientes())
                .thenReturn(Collections.singleton(DtoCliente.builder()
                        .nombreCompleto(cliente.getNombreCompleto()).build()));

        assertEquals(1L, servicioObtenerCliente.ejecutar().size());

    }
}
