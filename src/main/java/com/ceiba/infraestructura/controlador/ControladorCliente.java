package com.ceiba.infraestructura.controlador;


import com.ceiba.application.comando.ComandoCliente;
import com.ceiba.application.manejadores.ManejadorCrearCliente;
import com.ceiba.application.manejadores.ManejadorListarClientes;
import com.ceiba.dominio.modelo.dto.DtoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;
    private final ManejadorCrearCliente manejadorCrearCliente;

    @GetMapping()
    public Collection<DtoCliente> listar() {
        return manejadorListarClientes.ejecutar();
    }

    @PostMapping()
    public void crearCliente(@RequestBody ComandoCliente comandoCliente){
        manejadorCrearCliente.ejecutar(comandoCliente);
    }
}
