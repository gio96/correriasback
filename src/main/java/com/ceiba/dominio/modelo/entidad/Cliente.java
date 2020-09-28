package com.ceiba.dominio.modelo.entidad;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
//@AllArgsConstructor
//@NoArgsConstructor
public class Cliente {
    private final String id;
    private final String nombreCompleto;
    private final String ciudad;
    private final String telefono;
    private final String correoCliente;
}
