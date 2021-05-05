package com.example.demo.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


// this wrapper tells our application that this class is a bean to be injected into our controller
// @Service is more semantic than @Component, but they will both work the same.
@Service
// this class represent the service layer that is responsible for handling business logic
public class UserService {

    public List<User> getUsers() {
        return List.of(
                new User (
                        1L,
                        "Dazai",
                        "dazai@example.com",
                        21,
                        LocalDate.of(2000, Month.APRIL, 14)
                )
        );
    }

}
