package com.example.mobileappws.model.response;

import lombok.Data;

@Data
public class UserResponse {

    private String userId;
    private String firstName;
    private String lastName;

    public UserResponse() {}

    public  UserResponse(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
