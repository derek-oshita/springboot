package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// RestController allows UserController to serve REST endpoints
@RestController

// This wrapper will allow us to adjust the URL endpoint
@RequestMapping(path = "api/v1/user")

// UserController represents the API layer that will serve up our resources.
public class UserController {

    // this is a reference to our UserService where we are currently getting our data
    private final UserService userService;

    // this wrapper injects our reference above into our UserController and instantiates it
    @Autowired
    // this is the constructor where we pass userService to our controller
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // This wrapper determines that the request for this list will be a GET method
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

}
