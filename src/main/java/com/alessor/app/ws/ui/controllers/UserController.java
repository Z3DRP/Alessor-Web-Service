package com.alessor.app.ws.ui.controllers;

import com.alessor.app.ws.io.entities.Role;
import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.repositories.RoleRepo;
import com.alessor.app.ws.repositories.UserRepo;
import com.alessor.app.ws.shared.dtos.RegisterDTO;
import com.alessor.app.ws.ui.models.RoleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {

    private AuthenticationManager authenticationManager;
    private UserRepo userRepository;
    private RoleRepo roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserController(AuthenticationManager authManager, UserRepo usrRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authManager;
        this.userRepository = usrRepo;
        this.roleRepository = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register/alsr")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role roles = roleRepository.findByName(String.valueOf(RoleTypes.LESSOR)).get();
        user.setRoles(Collections.singletonList(roles));

        userRepository.save(user);
        return new ResponseEntity<>("User successfully registered", HttpStatus.OK);
    }

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
