package com.ceiba.dominio.repositorio;


import com.ceiba.dominio.modelo.entidad.Factura;

import java.util.List;

public interface RepositorioFactura {

    void crearFactura(Factura factura);

    List<Factura> listarFacturas(String idCliente);
}
