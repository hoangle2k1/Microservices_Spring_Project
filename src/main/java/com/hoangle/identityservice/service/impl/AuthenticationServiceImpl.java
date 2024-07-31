package com.hoangle.identityservice.service.impl;

import com.hoangle.identityservice.dto.request.AuthenticationRequest;
import com.hoangle.identityservice.exception.AppException;
import com.hoangle.identityservice.exception.ErrorCode;
import com.hoangle.identityservice.repository.UserRepository;
import com.hoangle.identityservice.service.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    UserRepository userRepository;

    //Chú ý cái access modifier, lớp implement lại interface
    //không được có AM nhỏ hơn phương thức trừu tượng trong Interface
    //Ít nhất phải bằng hoặc lớn hơn
    //Phương thức override không được có AM nhỏ hơn phương thức bị override
    @Override
    public boolean authenticate(AuthenticationRequest request) {
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        return passwordEncoder.matches(request.getPassword(), user.getPassword());
    }
}
