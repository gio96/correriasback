package com.ceiba.dominio.repositorio;


import com.ceiba.dominio.modelo.entidad.Cliente;

import java.util.Collection;
import java.util.Optional;

public interface RepositorioCliente {

    Collection<Cliente> listaClientes();

    void crearCliente(Cliente cliente);

    Optional<Cliente> obtenerCliente(String idCliente);
}
