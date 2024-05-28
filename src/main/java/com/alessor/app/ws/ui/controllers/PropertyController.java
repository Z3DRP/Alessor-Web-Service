package com.alessor.app.ws.ui.controllers;

import com.alessor.app.ws.ui.models.PropertyRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("properties")
public class PropertyController {

    @GetMapping
    public String getProperty() {
        return "Hello World";
    }

    @PostMapping
    public PropertyRequest createProperty() {
        return null;
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
