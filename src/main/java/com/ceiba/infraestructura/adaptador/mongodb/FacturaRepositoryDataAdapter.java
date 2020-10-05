package com.ceiba.infraestructura.adaptador.mongodb;

import com.ceiba.infraestructura.adaptador.data.FacturaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositoryDataAdapter extends MongoRepository<FacturaData, String> {
    List<FacturaData> findByIdCliente(String idClient);
}
