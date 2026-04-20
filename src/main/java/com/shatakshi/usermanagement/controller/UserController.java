package com.shatakshi.usermanagement.controller;

import com.shatakshi.usermanagement.dto.LoginRequest;
import com.shatakshi.usermanagement.dto.LoginResponse;
import com.shatakshi.usermanagement.dto.UserRequest;
import com.shatakshi.usermanagement.dto.UserResponse;
import com.shatakshi.usermanagement.entity.User;
import com.shatakshi.usermanagement.response.ApiResponse;
import com.shatakshi.usermanagement.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping
    public ApiResponse<UserResponse> createUser(@RequestBody UserRequest request) {
        UserResponse response = userService.createUser(request);

        return ApiResponse.<UserResponse>builder()
                .success(true)
                .data(response)
                .message("User created successfully")
                .build();
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getUsers() {
        List<UserResponse> users = userService.getAllUsers();

        return ApiResponse.<List<UserResponse>>builder()
                .success(true)
                .data(users)
                .message("Users fetched successfully")
                .build();
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }
}