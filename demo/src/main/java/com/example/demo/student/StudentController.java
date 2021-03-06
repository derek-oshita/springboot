package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// RestController allows StudentController to serve REST endpoints
@RestController

// This annotation will allow us to adjust the URL endpoint
@RequestMapping(path = "api/v1/student")

// StudentController represents the API layer that will serve up our resources.
public class StudentController {

    // this is a reference to our StudentService where we are currently getting our data
    private final StudentService studentService;

    // this annotation injects our reference above into our UserController and instantiates it automatically.
    // it's referred to as "dependency injection"
    @Autowired
    // this is the constructor where we pass userService to our controller
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // This annotation determines that the request for this list will be a GET method
    @GetMapping
    // then we create a method called getUsers that returns a list of users defined by studentService
    public List<Student> getUsers() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent (@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void destroyStudent (@PathVariable("studentId") Long studentId) {
        studentService.destroyStudent(studentId);
    }

    @PutMapping( path = "{studentId}")
    public void updateStudent (
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }

}
