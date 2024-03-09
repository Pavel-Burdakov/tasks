package com.github.pavelburdakov.userapp.client;

import com.github.pavelburdakov.userapp.model.User;
import com.github.pavelburdakov.userapp.web.dto.CreateUserRequest;

import java.util.List;

/**
 * интерфейс для клиента, который будет
 * взаимодействовать с Keycloak
 */
public interface UserClient {
    User createUser(CreateUserRequest request);

    List<User> getUsers();
}
