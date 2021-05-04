package com.example.demo.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    @GetMapping
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
