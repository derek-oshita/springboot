package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


// this annotation tells our application that this class is a bean to be injected into our controller
// @Service is more semantic than @Component, but they will both work the same.
@Service
// this class represent the service layer that is responsible for handling business logic
public class StudentService {

    // declare a constant variable representing the database access layer
    private final StudentRepository studentRepository;

    //
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

}