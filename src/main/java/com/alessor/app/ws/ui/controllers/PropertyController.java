package com.alessor.app.ws.ui.controllers;

import com.alessor.app.ws.service.PropertyService;
import com.alessor.app.ws.shared.dtos.PropertyDTO;
import com.alessor.app.ws.ui.models.PropertyRequest;
import com.alessor.app.ws.ui.models.PropertyRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("properties")
public class PropertyController {

    @Autowired
    PropertyService propertyService;

    @GetMapping
    public String getProperty() {
        return "Hello World";
    }

    @PostMapping
    public PropertyRes createProperty(@RequestBody PropertyRequest propertyDetails) {
        PropertyRes property = new PropertyRes();
        PropertyDTO propertyDTO = new PropertyDTO();
        BeanUtils.copyProperties(propertyDetails, propertyDTO);
        PropertyDTO createdProperty = propertyService.createProperty(propertyDTO);
        BeanUtils.copyProperties(createdProperty, property);
        return property;
    }

    @PutMapping
    public String updateProperty() {
        return null;
    }

    @DeleteMapping
    public String deleteProperty() {
        return null;
    }
}
