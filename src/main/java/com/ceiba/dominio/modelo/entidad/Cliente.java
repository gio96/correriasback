package com.ceiba.dominio.modelo.entidad;

public class Cliente {
    private String id;
    private String nombreCompleto;
    private String ciudad;
    private String telefono;
    private String correoCliente;


    public Cliente(String nombreCompleto, String ciudad, String telefono, String correoCliente) {
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correoCliente = correoCliente;
    }

    public Cliente(String id, String nombreCompleto, String ciudad, String telefono, String correoCliente) {
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
