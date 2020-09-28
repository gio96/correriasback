package com.ceiba.infraestructura.adaptador.mongodb;

import com.ceiba.infraestructura.adaptador.data.ClienteData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositoryDataAdapter extends MongoRepository<ClienteData, String> {
}
