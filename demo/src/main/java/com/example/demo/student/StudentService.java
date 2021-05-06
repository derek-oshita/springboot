package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


// this annotation tells our application that this class is a bean to be injected into our controller
// @Service is more semantic than @Component, but they will both work the same.
@Service
// this class represent the service layer that is responsible for handling business logic
public class StudentService {

    // declare a constant variable representing the database access layer
    private final StudentRepository studentRepository;

    // dependency injection
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("That email is already taken.");
        }
        studentRepository.save(student);
        System.out.println("Student created: " + student.getName());
    }

    public void destroyStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist.");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "Student with ID " + studentId + " does not exist!"
                ));

        if (name != null
                && name.length() > 0
                && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null
                && email.length() > 0
                && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            // if updated email already exists
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("That email is already taken!");
            } else {
                student.setEmail(email);
            }
        }

    }
}
