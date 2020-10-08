package com.ceiba.infraestructura.adaptador.data;

import javax.persistence.*;

@Entity(name = "ClienteH")
//@Table(name = ClienteH.TABLE_NAME)
public class ClienteH {
    public static final String TABLE_NAME= "Clientes";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombreCompleto;
    private String ciudad;
    private String telefono;
    private String correoCliente;

    public ClienteH(String nombreCompleto, String ciudad, String telefono, String correoCliente) {
        this.nombreCompleto = nombreCompleto;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correoCliente = correoCliente;
    }

    public ClienteH() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}
