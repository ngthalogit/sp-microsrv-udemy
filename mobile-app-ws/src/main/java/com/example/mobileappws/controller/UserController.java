package com.example.mobileappws.controller;


import com.example.mobileappws.model.request.UserRequest;
import com.example.mobileappws.model.request.UserUpdate;
import com.example.mobileappws.model.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/users")
public class UserController {
    private Map<String, UserResponse> users;

    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                           @RequestParam(value = "limit", defaultValue = "50", required = false) int limit,
                           @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return "get users was called with page = %d, limit = %d, and sort = %s".formatted(page, limit, sort);
    }

    @GetMapping(value = "{userId}",
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") String userId) {
//        UserResponse returned = new UserResponse(
//                "1",
//                "Monkey.D",
//                "Luffy"
//        );
//        return new ResponseEntity<UserResponse>(returned, HttpStatus.OK);
        if (users.containsKey(userId))
            return new ResponseEntity<UserResponse>(users.get(userId), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        String userId = UUID.randomUUID().toString();
        userRequest.setUserId(userId);
        userResponse.setUserId(userRequest.getUserId());
        userResponse.setFirstName(userRequest.getFirstName());
        userResponse.setLastName(userRequest.getLastName());
        if (users == null)
            users = new HashMap<>();
        users.put(userResponse.getUserId(), userResponse);
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{userId}",
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            })
    public UserResponse updateUser(@PathVariable("userId") String userId,
                                   @Valid @RequestBody UserUpdate userUpdate) {
        UserResponse existingUser = users.get(userId);
        existingUser.setFirstName(userUpdate.getFirstName());
        existingUser.setLastName(userUpdate.getLastName());
        return existingUser;
    }

    @DeleteMapping("{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") String userId) {
        users.remove(userId);
        return ResponseEntity.noContent().build();
    }

}
