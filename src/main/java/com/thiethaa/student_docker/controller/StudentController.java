package com.thiethaa.student_docker.controller;

import com.thiethaa.student_docker.entity.Student;
import com.thiethaa.student_docker.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping("/welcome")
    public String greeting(){
        return "Welcome To the Student Portal 2020";
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }
}
