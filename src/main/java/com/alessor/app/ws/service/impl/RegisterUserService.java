package com.alessor.app.ws.service.impl;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.service.RegisterService;
import com.alessor.app.ws.shared.dtos.RegisterDTO;
import com.alessor.app.ws.shared.lib.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService implements RegisterService {

    private final int ID_LEN = 30;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    Utils utils;

    @Override
    public void copyUserDetails(RegisterDTO rdto, UserEntity user) {
        user.setUsername(rdto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(rdto.getPassword()));
        user.setFirstName(rdto.getFirstName());
        user.setLastName(rdto.getLastName());
        user.setUId(utils.generateUserId(ID_LEN));
        user.setEmail(rdto.getEmail());
        user.setPhone(rdto.getPhone());
        user.setCreationDate(utils.getCurrentDateTime());
    }
}
