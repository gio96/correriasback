package com.ceiba.infraestructura.testdatabuilder;


import com.ceiba.application.comando.ComandoCliente;

public class ComandoClienteTestDataBuilder {

    private String nombreCompleto;
    private String ciudad;
    private String telefono;
    private String correoCliente;

    public ComandoClienteTestDataBuilder() {
        this.nombreCompleto = "Pepito";
        this.ciudad = "Medellin";
        this.telefono = "3145654343";
        this.correoCliente = "pepito@gmail.com";

    }

    public ComandoClienteTestDataBuilder conNombre(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
        return this;
    }

    public ComandoClienteTestDataBuilder conCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }

    public ComandoClienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ComandoClienteTestDataBuilder conCorreo(String correoCliente) {
        this.correoCliente = correoCliente;
        return this;
    }

    public ComandoCliente build() {
        return ComandoCliente.builder()
                .nombreCompleto(this.nombreCompleto)
                .ciudad(this.ciudad)
                .telefono(this.telefono)
                .correoCliente(this.correoCliente).build();
    }
}
