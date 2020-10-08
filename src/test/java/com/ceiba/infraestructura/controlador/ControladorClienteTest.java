package com.ceiba.infraestructura.controlador;

import com.ceiba.application.comando.ComandoCliente;
import com.ceiba.infraestructura.testdatabuilder.ComandoClienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ControladorClienteTest {

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void crearClienteTest() throws Exception {
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().build();
        mocMvc.perform(MockMvcRequestBuilders
                .post("/correrias/clientes")
                .content(objectMapper.writeValueAsString(comandoCliente))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void listarClientesTest() throws Exception {
        mocMvc.perform(MockMvcRequestBuilders
                .get("/correrias/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void validar() throws Exception {
        mocMvc.perform(MockMvcRequestBuilders
                .get("/correrias/clientes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[*].nombreCompleto").value("Pepito"));;
    }



    @Test
    public void obtenerClienteTestError() throws Exception {
        mocMvc.perform(MockMvcRequestBuilders
                .get("/correrias/clientes/{idCliente}", "5f717187b865cb1c5ffa122c")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}
