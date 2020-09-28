package com.ceiba.infraestructura.controlador;


import com.ceiba.application.manejadores.ManejadorListarClientes;
import com.ceiba.dominio.modelo.dto.DtoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ConsultarControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;

    @GetMapping()
    public Collection<DtoCliente> listar() {
        return manejadorListarClientes.ejecutar();
    }
}
