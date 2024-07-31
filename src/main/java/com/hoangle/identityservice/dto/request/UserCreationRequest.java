package com.hoangle.identityservice.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class UserCreationRequest {
    //Id generated automatically,don't need to define here
    @Size(min = 6, message = "USERNAME_INVALID")
    String username;

    //In the future gonna define a file for FINAL field
    String firstname;
    String lastname;
    @Size(min = 6, message = "INVALID_PASSWORD")
    String password;
    LocalDate dob;

}
