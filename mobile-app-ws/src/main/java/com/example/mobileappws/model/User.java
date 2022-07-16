package com.example.mobileappws.model;

import lombok.Data;

@Data
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;

    public User() {
    }

    public User(String userId, String firstName, String lastName, String email) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
