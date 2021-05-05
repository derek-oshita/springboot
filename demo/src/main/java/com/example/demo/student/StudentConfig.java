package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student dazai = new Student(
                    "Dazai",
                    "dazai@example.com",
                    21,
                    LocalDate.of(2000, Month.APRIL, 14)
            );

            Student fyodor = new Student(
                    "Fyodor",
                    "fyodor@example.com",
                    22,
                    LocalDate.of(1999, Month.APRIL, 14)
            );

            repository.saveAll(
                    List.of(dazai, fyodor)
            );
        };
    }
}
