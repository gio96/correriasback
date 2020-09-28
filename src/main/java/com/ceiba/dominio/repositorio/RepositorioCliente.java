package com.ceiba.dominio.repositorio;


import com.ceiba.dominio.modelo.dto.DtoCliente;

import java.util.Collection;

public interface RepositorioCliente {

    Collection<DtoCliente> listaClientes();
}
