package com.alessor.app.ws.repositories;

import com.alessor.app.ws.io.entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepo extends JpaRepository<Tenant, Integer> {

}
