package com.ceiba.application.fabrica;

import com.ceiba.application.comando.ComandoFactura;
import com.ceiba.application.comando.ComandoProducto;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricaFactura {
    public Factura crearFactura(ComandoFactura comandoFactura) {
        return new Factura(comandoFactura.getDescuentoFactura(),productoDtoToProducto(comandoFactura.getProductos()),new Date());
        /*return Factura.builder()
                .descuentoFactura(comandoFactura.getDescuentoFactura())
                .productos(productoDtoToProducto(comandoFactura.getProductos()))
                .fechaGenerada(new Date())
                .build();*/

    }

    private List<Producto> productoDtoToProducto(List<ComandoProducto> comandoProductosList) {
        return comandoProductosList.stream()
                .map(comandoProducto -> {
                    return new Producto(comandoProducto.getNombreProducto(), comandoProducto.getCantidad(), comandoProducto.getValorUnitario());
                }).collect(Collectors.toList());
                /*.map(comandoProducto -> Producto.builder()
                        .nombreProducto(comandoProducto.getNombreProducto())
                        .valorUnitario(comandoProducto.getValorUnitario())
                        .cantidad(comandoProducto.getCantidad())
                        .build()).collect(Collectors.toList());*/
    }
}
