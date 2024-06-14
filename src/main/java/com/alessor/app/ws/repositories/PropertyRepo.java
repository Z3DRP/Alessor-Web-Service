package com.alessor.app.ws.repositories;

import com.alessor.app.ws.shared.dtos.PropertyDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.alessor.app.ws.io.entities.PropertyEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepo extends CrudRepository<PropertyEntity, Integer>{

    @Query("SELECT p FROM Properties p WHERE p.city = :city")
    List<PropertyEntity> findByCity(@Param("city") String city);
}
