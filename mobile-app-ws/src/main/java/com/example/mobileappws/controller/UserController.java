package com.example.mobileappws.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping()
    public String getUsers(@RequestParam(value = "page",defaultValue = "1", required = false) int page,
                           @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called with page = %d, limit = %d, and sort = %s".formatted(page, limit, sort);
    }

    @GetMapping("{userId}")
    public String getUserById(@PathVariable("userId") String userId) {
        return "get user by id was called";
    }

    @PostMapping
    public String createUser() {
        return "creat user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update use was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }

}
