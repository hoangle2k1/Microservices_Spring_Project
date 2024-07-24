package com.hoangle.identityservice.controller;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.dto.response.ApiResponse;
import com.hoangle.identityservice.entity.User;
import com.hoangle.identityservice.service.impl.UserServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    @PostMapping()
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();
        apiResponse.setResult(userServiceImpl.createUser(request));
        return apiResponse;
    }

    @GetMapping()
    List<User> getUser(){
        return userServiceImpl.getUsers();
    }

    @GetMapping({"{userId}"})
    User getUserById(@PathVariable("userId") String userId){
        return userServiceImpl.getUser(userId);
    }

    @PutMapping("{userId}")
    User updateUserById(@PathVariable String userId, @RequestBody UserUpdateRequest request){
        return userServiceImpl.updateUser(userId,request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable String userId){
        userServiceImpl.deleteUser(userId);
        return "User has been deleted";
    }
}
