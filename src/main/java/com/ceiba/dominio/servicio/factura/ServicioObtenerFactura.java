package com.ceiba.dominio.servicio.factura;

import com.ceiba.dominio.excepcion.ClienteException;
import com.ceiba.dominio.modelo.dto.DtoFacturaResponse;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;
import lombok.RequiredArgsConstructor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.ceiba.dominio.utils.StringUtils.validarObligatorio;

public class ServicioObtenerFactura {
    private final RepositorioFactura repositorioFactura;
    private final RepositorioCliente repositorioCliente;

    public ServicioObtenerFactura(RepositorioFactura repositorioFactura, RepositorioCliente repositorioCliente) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioCliente = repositorioCliente;
    }

    public List<DtoFacturaResponse> ejecutar(String idCliente) {
        validarObligatorio(idCliente);
        obtenerClientePorId(idCliente);

        return this.repositorioFactura.listarFacturas(idCliente)
                .stream().map(factura -> {
                    return new DtoFacturaResponse(factura.getId(),factura.getIdCliente(),factura.getDescuentoFactura(),
                            factura.getProductos(),convertDateToString(factura.getFechaGenerada()),factura.getTotalFactura());
                }).collect(Collectors.toList());
                /*.stream().map(factura -> {
                    return DtoFacturaResponse.builder()
                            .id(factura.getId())
                            .idCliente(factura.getIdCliente())
                            .descuentoFactura(factura.getDescuentoFactura())
                            .fechaGenerada(convertDateToString(factura.getFechaGenerada()))
                            .productos(factura.getProductos())
                            .totalFactura(factura.getTotalFactura())
                            .build();
                }).collect(Collectors.toList());*/
    }

    private Cliente obtenerClientePorId(String idCliente) {
        return this.repositorioCliente.obtenerCliente(idCliente)
                .filter(cliente -> Objects.nonNull(cliente.getId()))
                .orElseThrow(ClienteException.Type.CLIENTE_NOT_FOUND::build);
    }

    private String convertDateToString(Date fechaMongo) {
        DateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");
        return formatter.format(fechaMongo);
    }

}
