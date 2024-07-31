package com.hoangle.identityservice.service.impl;

import com.hoangle.identityservice.dto.request.UserCreationRequest;
import com.hoangle.identityservice.dto.request.UserUpdateRequest;
import com.hoangle.identityservice.dto.response.UserResponse;
import com.hoangle.identityservice.entity.User;
import com.hoangle.identityservice.exception.AppException;
import com.hoangle.identityservice.exception.ErrorCode;
import com.hoangle.identityservice.mapper.UserMapper;
import com.hoangle.identityservice.repository.UserRepository;
import com.hoangle.identityservice.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    UserMapper userMapper;

    @Override
    public UserResponse createUser(UserCreationRequest request){
        //This line always return null bro :D, what fuk
        //userRepository.existsByUsername(user.getUsername());
        if (userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);
        User user = userMapper.toUser(request);
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUser(String id){
        //return an Optional, if null response error
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("User not found")));
    }

    @Override
    public UserResponse updateUser(String id, UserUpdateRequest request){
        User user = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
        userMapper.updateUser(user,request);
        return userMapper.toUserResponse(userRepository.save(user));
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
