package com.alessor.app.ws.service;

import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.shared.dtos.RegisterDTO;

public interface RegisterService {
    public void copyUserDetails(RegisterDTO rdto, UserEntity user);
}
