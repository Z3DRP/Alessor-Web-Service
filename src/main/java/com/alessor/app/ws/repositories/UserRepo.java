package com.alessor.app.ws.repositories;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.shared.dtos.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    @Query("SELECT u FROM Users u WHERE u.emailVerificationStatus = :param")
    List<UserEntity> findUsersByVerificationStatus(@Param("param") Boolean status);

    UserEntity findByEmail(String email);
}
