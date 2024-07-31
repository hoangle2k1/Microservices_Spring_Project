package com.hoangle.identityservice.controller;

import com.hoangle.identityservice.dto.request.AuthenticationRequest;
import com.hoangle.identityservice.dto.response.ApiResponse;
import com.hoangle.identityservice.dto.response.AuthenticationResponse;
import com.hoangle.identityservice.service.impl.AuthenticationServiceImpl;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping("/auth")
public class AuthenticationController {
    AuthenticationServiceImpl authenticationService;

    @PostMapping("/log-in")
    ApiResponse<AuthenticationResponse> login(@RequestBody AuthenticationRequest request){
        boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .result(AuthenticationResponse.builder()
                        .isAuthenticated(result)
                        .build())
                .build();
    }
}
