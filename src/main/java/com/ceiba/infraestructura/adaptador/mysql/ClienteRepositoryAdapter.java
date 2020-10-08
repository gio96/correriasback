package com.ceiba.infraestructura.adaptador.mysql;

import com.ceiba.infraestructura.adaptador.data.ClienteH;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryAdapter extends CrudRepository<ClienteH,Long> {
}
