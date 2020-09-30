package com.ceiba.infraestructura.config;


import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import com.ceiba.dominio.servicio.cliente.ServicioCrearCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerListaClientes;
import com.ceiba.dominio.servicio.factura.ServicioCrearFactura;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioObtenerListaClientes servicioObtenerListaClientes(RepositorioCliente repositorioCliente){
        return new ServicioObtenerListaClientes(repositorioCliente);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente){
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearFactura servicioCrearFactura(RepositorioFactura repositorioFactura, RepositorioCliente repositorioCliente){
        return new ServicioCrearFactura(repositorioFactura, repositorioCliente);
    }

    @Bean
    public ServicioObtenerCliente servicioObtenerCliente(RepositorioCliente repositorioCliente){
        return new ServicioObtenerCliente(repositorioCliente);
    }
}
