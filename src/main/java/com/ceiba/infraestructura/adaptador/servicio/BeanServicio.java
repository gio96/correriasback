package com.ceiba.infraestructura.adaptador.servicio;


import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.servicio.cliente.ServicioCrearCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioObtenerCliente servicioObtenerCliente(RepositorioCliente repositorioCliente){
        return new ServicioObtenerCliente(repositorioCliente);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente){
        return new ServicioCrearCliente(repositorioCliente);
    }
}
