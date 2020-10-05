package com.ceiba.dominio.servicio.factura;

import com.ceiba.dominio.excepcion.ClienteException;
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

import static com.ceiba.dominio.utils.StringUtils.validarObligatorio;

@RequiredArgsConstructor
public class ServicioObtenerFactura {
    private final RepositorioFactura repositorioFactura;
    private final RepositorioCliente repositorioCliente;

    public List<Factura> ejecutar(String idCliente) {
        validarObligatorio(idCliente);
        obtenerClientePorId(idCliente);

        return repositorioFactura.listarFacturas(idCliente);
    }

    private Cliente obtenerClientePorId(String idCliente) {
        return repositorioCliente.obtenerCliente(idCliente)
                .filter(cliente -> Objects.nonNull(cliente.getId()))
                .orElseThrow(ClienteException.Type.CLIENTE_NOT_FOUND::build);
    }

    private String convertDateToString(Date fechaMongo) {
        DateFormat formatter = new SimpleDateFormat("MMMM dd yyyy");
        return formatter.format(fechaMongo);
    }

}
