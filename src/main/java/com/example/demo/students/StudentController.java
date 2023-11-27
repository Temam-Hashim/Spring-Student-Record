package com.example.demo.students;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
//        throw new NotFoundException("sorry no students found");
    }

    @GetMapping(path="{studentId}")
    public Student getStudent(@PathVariable("studentId") UUID studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping
    public ResponseEntity<Map> addStudent(@Valid @RequestBody Student student){
        int st = studentService.addStudent(null,student);
        Map<String,String> map = new HashMap();
        map.put("message","student created");
        map.put("status","success");
        map.put("code","200");

        if(st==1){
            return ResponseEntity.status(HttpStatus.CREATED).body(map);
        }
        return null;
    }

    @DeleteMapping(path = "studentId")
    public void deleteStudent(@PathVariable("studnetId") UUID studentId){
        studentService.deleteStudent(studentId);
    }





}
