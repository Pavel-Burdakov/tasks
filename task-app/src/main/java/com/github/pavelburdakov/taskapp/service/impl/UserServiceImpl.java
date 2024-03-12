package com.github.pavelburdakov.taskapp.service.impl;

import com.github.pavelburdakov.taskapp.client.UserClient;
import com.github.pavelburdakov.taskapp.service.UserService;
import com.github.pavelburdakov.taskapp.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserClient userClient;

    @Override
    public List<UserDto> getUsers() {
        return userClient.getUsers();
    }
}