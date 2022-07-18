package com.example.mobileappws.model.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserRequest {
    private String userId;
    @NotNull
    @Size(min = 2, message = "first name must be at least 2 characters")
    private String firstName;
    @NotNull
    @Size(min = 2, message = "last name must be at least 2 characters")
    private String lastName;
    @Email(message = "email cannot be null")
    private String email;
    @NotNull
    @Size(min = 8, max = 16, message = "password must be equal 8 and less than 16 characters")
    private String password;

    private String address;
    public UserRequest() {
    }

    public UserRequest(String userId, String firstName, String lastName, String email, String password, String address) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = address;
    }
}
