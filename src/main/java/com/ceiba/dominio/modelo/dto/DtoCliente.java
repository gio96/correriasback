package com.ceiba.dominio.modelo.dto;

public class DtoCliente {
    private final String id;
    private final String nombreCompleto;
    private final String ciudad;
    private final String telefono;
    private final String correoCliente;

    public DtoCliente(String id, String nombreCompleto, String ciudad, String telefono, String correoCliente) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correoCliente = correoCliente;
    }

    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }
}
