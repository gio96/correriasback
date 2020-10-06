package com.ceiba.infraestructura.config;


import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import com.ceiba.dominio.servicio.cliente.ServicioCrearCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerCliente;
import com.ceiba.dominio.servicio.cliente.ServicioObtenerListaClientes;
import com.ceiba.dominio.servicio.factura.ServicioCrearFactura;
import com.ceiba.dominio.servicio.factura.ServicioObtenerFactura;
import com.ceiba.infraestructura.controlador.TcrmCliente;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

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

    @Bean
    public ServicioObtenerFactura servicioObtenerFactura(RepositorioFactura repositorioFactura, RepositorioCliente repositorioCliente){
        return new ServicioObtenerFactura(repositorioFactura, repositorioCliente);
    }

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("com.ceiba.infraestructura.soap");
        return jaxb2Marshaller;
    }

    @Bean
    public TcrmCliente tcrmCliente(Jaxb2Marshaller jaxb2Marshaller){
        TcrmCliente tcrmCliente = new TcrmCliente();
        tcrmCliente.
                setDefaultUri("https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService");
        tcrmCliente.setMarshaller(jaxb2Marshaller);
        tcrmCliente.setUnmarshaller(jaxb2Marshaller);
        return tcrmCliente;
    }
}
