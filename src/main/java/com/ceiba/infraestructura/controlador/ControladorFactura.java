package com.ceiba.infraestructura.controlador;


import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.manejadores.ManejadorCrearFactura;
import com.ceiba.application.manejadores.ManejadorObtenerFacturas;
import com.ceiba.dominio.modelo.entidad.Factura;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;
    private final ManejadorObtenerFacturas manejadorObtenerFacturas;

    @PostMapping(value = "/{idClient}/facturas")
    public void crearFactura(@PathVariable String idClient, @RequestBody ComandoFactura comandoFactura) {
        manejadorCrearFactura.ejecutar(idClient, comandoFactura);
    }

    @GetMapping(value = "/{idClient}/facturas")
    public List<Factura> obtenerFacturas(@PathVariable String idClient) {
        return manejadorObtenerFacturas.ejecutar(idClient);
    }
}
