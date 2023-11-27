package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Repository
public class StudentDataAccess {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDataAccess(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate = jdbcTemplate;
    }

    List<Student> SelectAllStudents(){

        String sql = "SELECT studentId,firstName,lastName,email,mobile,gender,password,created_at FROM student";

        List<Student> students = jdbcTemplate.query(sql,(resultSet, i) -> {

            return getStudent(resultSet);
        });

        return students;
    }


    public int insertStudent(UUID newStudentID, Student student) {
        String sql = "INSERT INTO student (studentId, firstName, lastName, email, mobile, gender,password) VALUES (?, ?, ?, ?, ?,?::ENUM,?)";
        int result = jdbcTemplate.update(sql, newStudentID,student.getFirstName(),student.getLastName(),student.getEmail(),student.getMobile(),student.getGender().name().toUpperCase(),student.getPasswword());
        return result;
    }


    // Delete a student by studentId
    public void deleteStudentById(UUID studentId) {
        String sql = "DELETE FROM student WHERE studentId = ?";
        jdbcTemplate.update(sql, studentId);
    }

    Student getStudentById(UUID studentId) {
        String sql = "SELECT studentId, firstName, lastName, email, mobile, gender,password, created_at FROM student WHERE studentId = ?";
        // Use jdbcTemplate's query method with a RowMapper and parameterized query
        List<Student> students = jdbcTemplate.query(sql, new Object[]{studentId}, (resultSet, i) -> {
            return getStudent(resultSet);
        });
        // Check if any student was found and return it
        if (!students.isEmpty()) {
            return students.get(0);
        } else {
            return null; // Return null if no student with the given ID was found
        }
    }

    Boolean getStudentByEmail(String email) {
        String sql = "SELECT EXISTS (SELECT 1 FROM student WHERE email = ?)";
        // Use jdbcTemplate's query method with a RowMapper and parameterized query
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (resultSet, i) -> {
            return resultSet.getBoolean(1);
        });
    }

    Boolean getStudentByMobile(String mobile) {
        String sql = "SELECT EXISTS (SELECT 1 FROM student WHERE mobile = ?)";

        return jdbcTemplate.queryForObject(sql, new Object[]{mobile}, (resultSet, i) -> {
            return resultSet.getBoolean(1);
        });
    }

    private static Student getStudent(ResultSet resultSet) throws SQLException {
        String studentIdStr = resultSet.getString("studentId");
        UUID studentId = UUID.fromString((studentIdStr));
        String firstName =  resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        String email = resultSet.getString("email");
        String mobile = resultSet.getString("mobile");
        String genderStr = resultSet.getString("gender");
        Student.Gender gender = Student.Gender.valueOf(genderStr);
        String password = resultSet.getString("password");

        return new Student(studentId, firstName, lastName, email, mobile, gender, password);
    }








}
