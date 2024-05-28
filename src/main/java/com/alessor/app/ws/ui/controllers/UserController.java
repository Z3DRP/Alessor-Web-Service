package com.alessor.app.ws.ui.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "Hello World";
    }

    @PostMapping
    public String postUser() {
        return "Hello World";
    }

    @PutMapping
    public String putUser() {
        return "Hello World";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Hello World";
    }
}
