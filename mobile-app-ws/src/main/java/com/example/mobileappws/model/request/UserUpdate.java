package com.example.mobileappws.model.request;

import lombok.Data;

@Data
public class UserUpdate {
    private String firstName;
    private String lastName;

    public UserUpdate() { }
    public UserUpdate(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
