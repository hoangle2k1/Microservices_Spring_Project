package com.hoangle.identityservice.service.impl;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.entity.User;
import com.hoangle.identityservice.repository.UserRepository;
import com.hoangle.identityservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User createUser(UserCreationRequest request){
        User user = new User();

        //This line always return null bro :D, what fuk
        //userRepository.existsByUsername(user.getUsername());

        if (userRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("User existed");

        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public User getUser(String id){
        //return an Optional, if null response error
        return userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("User not found") );
    }

    @Override
    public User updateUser(String id, UserUpdateRequest request){
        User user = getUser(id);

        user.setPassword(request.getPassword());
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    @Override
    public boolean checkExistsUser() {
        return false;
    }
}
