package com.example.demo.students;

import com.example.demo.exception.AlreadyExistException;
import com.example.demo.exception.ApiRequestException;
import com.example.demo.validator.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class StudentService {

    private final StudentDataAccess studentDataAccess;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccess studentDataAccess, EmailValidator emailValidator) {
        this.studentDataAccess = studentDataAccess;
        this.emailValidator = emailValidator;
    }

    public List<Student> getStudents(){
        return studentDataAccess.SelectAllStudents();
    }

    public Student getStudent(UUID studentId){
        return studentDataAccess.getStudentById(studentId);
    }

    public int addStudent(UUID studentId, Student student){
        UUID newStudentID = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

//     check duplicate email
        if(studentDataAccess.getStudentByEmail(student.getEmail())){
            throw new AlreadyExistException("Email:"+student.getEmail()+ " already Exists");
        }
//      check duplicate mobile
        if(studentDataAccess.getStudentByMobile(student.getMobile())){
            throw new AlreadyExistException("Mobile No: "+student.getMobile()+ " already Exists");
        }

       if( !emailValidator.test(student.getEmail()) ) {
          throw new ApiRequestException(student.getEmail()+" is invalid email address");
       }

        return studentDataAccess.insertStudent(newStudentID,student);
    }

    public void deleteStudent(UUID studentId){
        studentDataAccess.deleteStudentById(studentId);
    }








}
