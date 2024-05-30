package com.alessor.app.ws.service;

import com.alessor.app.ws.shared.dtos.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO usr);

    List<UserDTO> findUsersByVerificationStatus(Boolean status);
}
