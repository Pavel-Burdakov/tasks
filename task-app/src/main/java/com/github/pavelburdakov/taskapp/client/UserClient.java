package com.github.pavelburdakov.taskapp.client;

import com.github.pavelburdakov.taskapp.web.dto.UserDto;

import java.util.List;

public interface UserClient {
    List<UserDto> getUsers();
}
