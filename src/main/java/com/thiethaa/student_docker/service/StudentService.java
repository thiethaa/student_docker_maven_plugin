package com.thiethaa.student_docker.service;

import com.thiethaa.student_docker.utils.StudentUtil;
import com.thiethaa.student_docker.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    public Student addStudent(Student student){
        return student;
    }

    public List<Student> getStudents(){
        return StudentUtil.getStudents();
    }

}
