package com.hoangle.identityservice.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserUpdateRequest {
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;
}
