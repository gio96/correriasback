package com.ceiba.infraestructura.adaptador.mongodb;

import com.ceiba.infraestructura.adaptador.data.FacturaData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositoryDataAdapter extends MongoRepository<FacturaData, String> {
}
