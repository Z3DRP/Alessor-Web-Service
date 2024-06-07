package com.alessor.app.ws.repositories;

import com.alessor.app.ws.io.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {

    Role findByName(String name);
}
