package com.hoangle.identityservice.service;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.entity.User;

import java.util.List;

public interface UserService {
    public User createUser(UserCreationRequest request);

    public List<User> getUsers();

    public User getUser(String id);

    public User updateUser(String id, UserUpdateRequest request);

    public void deleteUser(String userId);

    public boolean checkExistsUser();
}
