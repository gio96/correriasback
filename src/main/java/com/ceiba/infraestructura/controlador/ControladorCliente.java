package com.ceiba.infraestructura.controlador;


import com.ceiba.application.comando.ComandoCliente;
import com.ceiba.application.manejadores.ManejadorCrearCliente;
import com.ceiba.application.manejadores.ManejadorListarClientes;
import com.ceiba.application.manejadores.ManejadorObtenerCliente;
import com.ceiba.dominio.modelo.dto.DtoCliente;
import com.ceiba.dominio.modelo.entidad.Cliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;
    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorObtenerCliente manejadorObtenerCliente;

    @CrossOrigin
    @GetMapping()
    public Collection<DtoCliente> listar() {
        return manejadorListarClientes.ejecutar();
    }

    @CrossOrigin
    @PostMapping()
    public void crearCliente(@RequestBody ComandoCliente comandoCliente) {
        manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @CrossOrigin
    @GetMapping(value = "/{idClient}")
    public Cliente obtenerClient(@PathVariable String idClient) {
        return manejadorObtenerCliente.ejecutar(idClient);
    }
}
