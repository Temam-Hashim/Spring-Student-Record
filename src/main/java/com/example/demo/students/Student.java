package com.example.demo.students;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Entity
@Table(name="student")
public class Student {

    @Id
    @SequenceGenerator(
            name="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private final UUID studentId;

    @NotBlank(message="firstName required")
    private final String firstName;
    @NotBlank(message="lastName required")
    private final String lastName;
    @NotBlank(message="email required")
//    @Email(message = "Enter valid email address")
    private final String email;
    @NotBlank(message="mobile required")
    private final String mobile;

    private final Gender gender;
    @NotBlank(message="password required")
    private String password;




    enum Gender{
        MALE,FEMALE;
    }


    public Student(UUID studentId, String firstName, String lastName, String email, String mobile, Gender gender, String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.password = password;
    }

    public UUID getId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPasswword() {
        return password;
    }

    public void setPassword(String password){
        // Encrypt the password before setting it
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }

}
