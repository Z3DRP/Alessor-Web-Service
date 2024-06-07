package com.alessor.app.ws.service.impl;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.repositories.UserRepo;
import com.alessor.app.ws.service.UserService;
import com.alessor.app.ws.shared.dtos.UserDTO;
import com.alessor.app.ws.shared.lib.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IUser implements UserService {
    private final int ID_LEN = 30;

    //Video 39 for running secure version and 41 for signup
    @Autowired
    UserRepo userRepository;

    @Autowired
    Utils utils;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDTO createUser(UserDTO user) {

        if (userRepository.findByEmail(user.getEmail()) != null) throw new RuntimeException("Record already exists.");

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);

        String uid = utils.generateUserId(ID_LEN);
        userEntity.setUId(uid);
        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        UserEntity savedUser = userRepository.save(userEntity);
        UserDTO savedDTO = new UserDTO();
        BeanUtils.copyProperties(savedUser, savedDTO);
        return savedDTO;
    }

    @Override
    public List<UserDTO> findUsersByVerificationStatus(Boolean status) {
        List<UserEntity> userEntities = userRepository.findUsersByVerificationStatus(status);
        List<UserDTO> userDTOS = new ArrayList<>();

        for(UserEntity userEntity : userEntities) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }
}
