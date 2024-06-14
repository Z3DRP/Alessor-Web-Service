package com.alessor.app.ws.ui.controllers;

import com.alessor.app.ws.io.entities.Role;
import com.alessor.app.ws.io.entities.Tenant;
import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.io.entities.Worker;
import com.alessor.app.ws.repositories.RoleRepo;
import com.alessor.app.ws.repositories.TenantRepo;
import com.alessor.app.ws.repositories.UserRepo;
import com.alessor.app.ws.repositories.WorkerRepo;
import com.alessor.app.ws.service.RegisterService;
import com.alessor.app.ws.shared.dtos.RegisterDTO;
import com.alessor.app.ws.ui.models.RoleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;

@RestController
@RequestMapping("/users")
public class UserController {

    private AuthenticationManager authenticationManager;
    private UserRepo userRepository;
    private RoleRepo roleRepository;
    private TenantRepo tenantRepository;
    private WorkerRepo workerRepository;

    @Autowired
    private RegisterService registerService;

    @Autowired
    UserController(AuthenticationManager authManager, UserRepo usrRepo, RoleRepo roleRepo, TenantRepo tenantRepo, WorkerRepo workerRepo) {
        this.authenticationManager = authManager;
        this.userRepository = usrRepo;
        this.roleRepository = roleRepo;
        this.tenantRepository = tenantRepo;
        this.workerRepository = workerRepo;
    }

    @PostMapping("/alsr/register")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO) {
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        UserEntity usr = new UserEntity();
        registerUser(String.valueOf(RoleTypes.LESSOR), registerDTO, usr);
        return new ResponseEntity<>("User successfully registered", HttpStatus.OK);
    }

    @PostMapping("/tenant/register")
    public ResponseEntity<String> registerTenant(@RequestBody RegisterDTO registerDTO) {
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        UserEntity usr = new UserEntity();
        registerUser(String.valueOf(RoleTypes.TENANT), registerDTO, usr);
        Tenant tenant = new Tenant();
        tenant.setUser(usr);
        tenant.setEmployeer(registerDTO.getEmployer());
        tenant.setEmploymentLength(registerDTO.getEmploymentLength());
        tenant.setJobTitle(registerDTO.getJobTitle());
        tenant.setJobDescription(registerDTO.getJobDescription());
        tenantRepository.save(tenant);
        return new ResponseEntity<>("Tenant successfully registered", HttpStatus.OK);
    }

    @PostMapping("/worker/register")
    public ResponseEntity<String> registerWorker(@RequestBody RegisterDTO registerDTO) {
        if (userRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        UserEntity usr = new UserEntity();
        registerUser(String.valueOf(RoleTypes.MAINTENANCE), registerDTO, usr);
        Worker worker = new Worker();
        worker.setUser(usr);
        workerRepository.save(worker);
        return new ResponseEntity<>("Worker successfully registered", HttpStatus.OK);
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

    private void registerUser(String role, RegisterDTO registerDTO, UserEntity usr) {
        registerService.copyUserDetails(registerDTO, usr);
        Role roles = roleRepository.findByName(role).get();
        usr.setRoles(Collections.singletonList(roles));
        userRepository.save(usr);
    }
}
