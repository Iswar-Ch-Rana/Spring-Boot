package com.iswar.restdemo.rest;


import com.iswar.restdemo.enity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    // define @PostConstruct to load the Student data *** only once !

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("iswar", "rana"));
        theStudents.add(new Student("nikhil", "mohanty"));
        theStudents.add(new Student("satya", "pusty"));
    }

    // define endpoint for "/students" - return a list of student

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return a student
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        //check student if again list of size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }


}
