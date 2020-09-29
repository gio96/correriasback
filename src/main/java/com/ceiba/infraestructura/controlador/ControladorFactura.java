package com.ceiba.infraestructura.controlador;


import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.manejadores.ManejadorCrearFactura;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;

    @PostMapping(value = "/{idClient}/facturas")
    public void crearFactura(@PathVariable String idClient, @RequestBody ComandoFactura comandoFactura) {
        manejadorCrearFactura.ejecutar(idClient, comandoFactura);
    }
}
