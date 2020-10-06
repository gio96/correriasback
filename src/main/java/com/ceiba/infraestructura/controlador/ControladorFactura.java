package com.ceiba.infraestructura.controlador;


import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.manejadores.ManejadorCrearFactura;
import com.ceiba.application.manejadores.ManejadorObtenerFacturas;
import com.ceiba.dominio.modelo.dto.DtoFacturaResponse;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.infraestructura.soap.ObjectFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/correrias/clientes")
@RequiredArgsConstructor
public class ControladorFactura {

    private final ManejadorCrearFactura manejadorCrearFactura;
    private final ManejadorObtenerFacturas manejadorObtenerFacturas;
    private final TcrmCliente tcrmCliente;

    @CrossOrigin
    @PostMapping(value = "/{idClient}/facturas")
    public void crearFactura(@PathVariable String idClient, @RequestBody ComandoFactura comandoFactura) {
        manejadorCrearFactura.ejecutar(idClient, comandoFactura);
    }

    @CrossOrigin
    @GetMapping(value = "/{idClient}/facturas")
    public List<DtoFacturaResponse> obtenerFacturas(@PathVariable String idClient) {
        return manejadorObtenerFacturas.ejecutar(idClient);
    }


    @CrossOrigin
    @GetMapping(value = "/{idClient}/facturas/tcrm")
    public void obtenerFacturas() {
        tcrmCliente.getTcrm();
    }

}
