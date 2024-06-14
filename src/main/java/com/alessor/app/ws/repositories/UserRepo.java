package com.alessor.app.ws.repositories;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.shared.dtos.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT u FROM Users u WHERE u.emailVerificationStatus = :status")
    List<UserEntity> findUsersByVerificationStatus(@Param("status") Boolean status);

    UserEntity findByEmail(String email);

    Boolean existsByUsername(String username);

    Optional<UserEntity> findByUsername(String username);

    @Query("SELECT u FROM Users u WHERE u.username = :usrname")
    UserEntity getByUsername(@Param("usrname")String username);
}
