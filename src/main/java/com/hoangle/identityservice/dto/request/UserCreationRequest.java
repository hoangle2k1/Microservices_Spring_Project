package com.hoangle.identityservice.dto.request;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserCreationRequest {
    //Id generated automatically,don't need to define here
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private LocalDate dob;

}
