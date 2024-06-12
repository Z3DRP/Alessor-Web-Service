package com.alessor.app.ws.service;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.shared.dtos.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDTO createUser(UserDTO usr);

    List<UserDTO> findUsersByVerificationStatus(Boolean status);

    UserDTO findByEmail(String email);

    Boolean existsByUsername(String username);

}
