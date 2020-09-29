package com.ceiba.infraestructura.adaptador.data;

import com.ceiba.dominio.modelo.entidad.Producto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Facturas")
@Builder(toBuilder = true)
public class FacturaData {

    @Id
    private String id;
    private final String idCliente;
    private final double descuentoFactura;
    private final List<Producto> productos;
    private final Date fechaGenerada;
    private final double totalFactura;
}
