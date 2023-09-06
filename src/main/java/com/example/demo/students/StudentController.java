package com.example.demo.students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @GetMapping()
    public List<Student> getStudents(){
        return List.of(new Student(UUID.randomUUID(),"Temam","Hashim","temam@gmail.com","0987656392",Student.Gender.MALE),
        new Student(UUID.randomUUID(),"Sara","Jemal","sara@gmail.com","0982356392",Student.Gender.FEMALE)
    );
    }
}
