package com.alessor.app.ws.service;

import com.alessor.app.ws.shared.dtos.PropertyDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PropertyService {

    PropertyDTO createProperty(PropertyDTO property);

    List<PropertyDTO> findByCity(String city);
}
