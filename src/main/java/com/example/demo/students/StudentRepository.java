//package com.example.demo.students;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.UUID;
//
//public interface StudentRepository extends JpaRepository<Student, Long> {
//
//    @Query("SELECT s FROM Student s WHERE s.email = ?1")
//    Student findByEmail(String email);
//
//    @Query("SELECT s FROM Student s WHERE s.mobile = ?1")
//    Student findByMobile(String mobile);
//}
