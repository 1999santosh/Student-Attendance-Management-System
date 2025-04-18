package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Student;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> 
{
    Optional<Student> findByRollNumber(String rollNumber);
    Optional<Student> findByEmail(String email);
}
