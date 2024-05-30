package com.alessor.app.ws.service.impl;

import com.alessor.app.ws.io.entities.PropertyEntity;
import com.alessor.app.ws.repositories.PropertyRepo;
import com.alessor.app.ws.service.PropertyService;
import com.alessor.app.ws.shared.dtos.PropertyDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IProperty implements PropertyService {

    @Autowired
    PropertyRepo propertyRepository;

    @Override
    public PropertyDTO createProperty(PropertyDTO property) {
        PropertyEntity propertyEntity = new PropertyEntity();
        BeanUtils.copyProperties(property, propertyEntity);
        PropertyEntity savedProperty = propertyRepository.save(propertyEntity);

        PropertyDTO savedPropertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(savedProperty, savedPropertyDTO);
        return savedPropertyDTO;
    }

    @Override
    public List<PropertyDTO> findByCity(String city) {
        List<PropertyEntity> propertyEntities = propertyRepository.findByCity(city);
        List<PropertyDTO> propertyDTOS = new ArrayList<>();
        for (PropertyEntity property : propertyEntities) {
            PropertyDTO propertyDTO = new PropertyDTO();
            BeanUtils.copyProperties(property, propertyDTO);
            propertyDTOS.add(propertyDTO);
        }
        return propertyDTOS;
    }
}
