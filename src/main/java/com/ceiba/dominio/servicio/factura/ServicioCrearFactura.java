package com.ceiba.dominio.servicio.factura;

import com.ceiba.dominio.excepcion.ClienteException;
import com.ceiba.dominio.modelo.dto.DtoDescuentoFactura;
import com.ceiba.dominio.modelo.entidad.Cliente;
import com.ceiba.dominio.modelo.entidad.Factura;
import com.ceiba.dominio.repositorio.RepositorioCliente;
import com.ceiba.dominio.repositorio.RepositorioFactura;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import static com.ceiba.dominio.utils.FacturaUtils.calcularTotalFacturaDescuentoAdicional;
import static com.ceiba.dominio.utils.FacturaUtils.validarDiaNoVentas;
import static com.ceiba.dominio.utils.StringUtils.validarObligatorio;


public class ServicioCrearFactura {
    private final RepositorioFactura repositorioFactura;
    private final RepositorioCliente repositorioCliente;

    public ServicioCrearFactura(RepositorioFactura repositorioFactura, RepositorioCliente repositorioCliente) {
        this.repositorioFactura = repositorioFactura;
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(String idCliente, Factura factura) {
        validarObligatorio(idCliente);
        obtenerClientePorId(idCliente);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int diaActual = calendar.get(Calendar.DAY_OF_WEEK);
        validarDiaNoVentas(diaActual, Calendar.SUNDAY, Calendar.SATURDAY);

        DtoDescuentoFactura dtoDescuentoFactura = new DtoDescuentoFactura(factura, diaActual, 200000, Calendar.WEDNESDAY, 2);

        double totalFactura = calcularTotalFacturaDescuentoAdicional(dtoDescuentoFactura);

        Factura facturaCalculada = new Factura(idCliente, factura.getDescuentoFactura(), factura.getProductos(), factura.getFechaGenerada(), totalFactura);

        this.repositorioFactura.crearFactura(facturaCalculada);
    }

    private Cliente obtenerClientePorId(String idCliente) {
        return this.repositorioCliente.obtenerCliente(idCliente)
                .filter(cliente -> Objects.nonNull(cliente.getId()))
                .orElseThrow(ClienteException.Type.CLIENTE_NOT_FOUND::build);
    }

}
