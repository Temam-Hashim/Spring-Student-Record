package com.example.demo.students;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name="students")
public class Student {

    @Id
    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String mobile;
    private final Gender gender;




    enum Gender{
        MALE,FEMALE;
    }


    public Student(UUID id, String firstName, String lastName, String email, String mobile, Gender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
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
}
