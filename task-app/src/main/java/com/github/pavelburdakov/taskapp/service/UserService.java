package com.github.pavelburdakov.taskapp.service;

import com.github.pavelburdakov.taskapp.web.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
}
