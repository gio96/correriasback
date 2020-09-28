package com.ceiba.dominio.modelo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
//@AllArgsConstructor
public class DtoCliente {
    private final String id;
    private final String nombreCompleto;
    private final String ciudad;
    private final String telefono;
    private final String correoCliente;
}
