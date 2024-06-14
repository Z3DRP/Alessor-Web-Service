package com.alessor.app.ws.factories;

import com.alessor.app.ws.io.entities.Tenant;
import com.alessor.app.ws.io.entities.UserEntity;
import com.alessor.app.ws.io.entities.Worker;
import org.apache.catalina.User;

public class UserFactory {
    public static UserEntity createUser(String type) {
        return switch (type.toLowerCase()) {
            case "tenant" -> new Tenant();
            case "maintenance" -> new Worker();
            default -> new UserEntity();
        };
    }
}
