package com.ceiba.infraestructura.adaptador.dao;

import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import com.ceiba.infraestructura.adaptador.data.FacturaData;
import com.ceiba.infraestructura.adaptador.mongodb.FacturaRepositoryDataAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class RepositorioFacturaMongo implements RepositorioFactura {

    private final FacturaRepositoryDataAdapter facturaRepositoryDataAdapter;

    @Override
    public void crearFactura(Factura factura) {
        FacturaData facturaData = FacturaData.builder()
                .idCliente(factura.getIdCliente())
                .descuentoFactura(factura.getDescuentoFactura())
                .productos(factura.getProductos())
                .fechaGenerada(factura.getFechaGenerada())
                .totalFactura(factura.getTotalFactura())
                .build();

        facturaRepositoryDataAdapter.save(facturaData);
    }

    @Override
    public List<Factura> listarFacturas(String idCliente) {
        return facturaRepositoryDataAdapter.findByIdCliente(idCliente).stream()
                .map(facturaData -> {
                    return new Factura(facturaData.getId(), facturaData.getIdCliente(), facturaData.getDescuentoFactura(),
                            facturaData.getProductos(), facturaData.getFechaGenerada(), facturaData.getTotalFactura());
                }).collect(Collectors.toList());
    }
}
