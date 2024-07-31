package com.hoangle.identityservice.service;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.dto.response.UserResponse;
import com.hoangle.identityservice.entity.User;

import java.util.List;

public interface UserService {
    public UserResponse createUser(UserCreationRequest request);

    public List<User> getUsers();

    public UserResponse getUser(String id);

    public UserResponse updateUser(String id, UserUpdateRequest request);

    public void deleteUser(String userId);

    public boolean checkExistsUser();
}
