package com.ceiba.infraestructura.adaptador.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Clientes")
@Builder(toBuilder = true)
public class ClienteData {

    @Id
    private String id;
    private String nombreCompleto;
    private String ciudad;
    private String telefono;
    private String correoCliente;
}
