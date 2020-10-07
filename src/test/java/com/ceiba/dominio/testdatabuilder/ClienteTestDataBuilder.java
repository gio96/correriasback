package com.ceiba.dominio.testdatabuilder;


import com.ceiba.dominio.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private String id;
    private String nombreCompleto;
    private String ciudad;
    private String telefono;
    private String correoCliente;

    public ClienteTestDataBuilder() {
        this.id = "id";
        this.nombreCompleto = "Pepito";
        this.ciudad = "Medellin";
        this.telefono = "3145654343";
        this.correoCliente = "pepito@gmail.com";

    }

    public ClienteTestDataBuilder conId(String id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public ClienteTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ClienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ClienteTestDataBuilder conCorreo(String correoCliente) {
        this.correoCliente = correoCliente;
        return this;
    }

    public Cliente build() {
        return new Cliente(this.id,this.nombreCompleto,this.ciudad,this.telefono,this.correoCliente);
    }

}
