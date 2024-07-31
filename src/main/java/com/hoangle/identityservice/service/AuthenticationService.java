package com.hoangle.identityservice.service;

import com.hoangle.identityservice.dto.request.AuthenticationRequest;

public interface AuthenticationService {
    boolean authenticate(AuthenticationRequest request);
}
