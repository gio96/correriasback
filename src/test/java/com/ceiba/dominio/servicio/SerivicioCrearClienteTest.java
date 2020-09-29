package com.ceiba.dominio.servicio;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.servicio.cliente.ServicioCrearCliente;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SerivicioCrearClienteTest {

    @Mock
    private RepositorioCliente repositorioCliente;

    @InjectMocks
    private ServicioCrearCliente servicioCrearCliente;

    @Test
    public void validarCreacionCliente() {
        Cliente cliente = new ClienteTestDataBuilder().build();

        servicioCrearCliente.ejecutar(cliente);

        verify(repositorioCliente, times(1)).crearCliente(any(Cliente.class));

    }
}
