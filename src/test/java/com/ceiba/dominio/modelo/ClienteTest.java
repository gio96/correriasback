package com.ceiba.dominio.modelo;

import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.testdatabuilder.ClienteTestDataBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClienteTest {

    private static final String id = "idTest";
    private static final String nombreCompleto = "NombreTest";
    private static final String ciudad = "CiudadTest";
    private static final String telefono = "TelefonoTest";
    private static final String correoCliente = "CorreoTest";

    @Test
    public void crearCliente(){

        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder()
                .conId(id)
                .conNombre(nombreCompleto)
                .conCiudad(ciudad)
                .conTelefono(telefono)
                .conCorreo(correoCliente);

        //act
        Cliente cliente = clienteTestDataBuilder.build();

        //assert
        assertEquals(id, cliente.getId());
        assertEquals(nombreCompleto, cliente.getNombreCompleto());
        assertEquals(ciudad, cliente.getCiudad());
        assertEquals(telefono, cliente.getTelefono());
        assertEquals(correoCliente, cliente.getCorreoCliente());


    }
}
