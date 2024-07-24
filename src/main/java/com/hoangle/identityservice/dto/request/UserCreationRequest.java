package com.hoangle.identityservice.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
@Data
public class UserCreationRequest {
    //Id generated automatically,don't need to define here
    @Size(min = 6, message = "Username at least 6 characters")
    private String username;

    //In the future gonna define a file for FINAL field
    @Size(min = 6, message = "Password at least 6 characters")
    private String firstname;
    private String lastname;
    private LocalDate dob;

}
