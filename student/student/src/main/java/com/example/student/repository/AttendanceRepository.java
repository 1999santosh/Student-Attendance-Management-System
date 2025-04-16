package com.example.student.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.entity.Attendance;
import com.example.student.entity.Student;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
     List<Attendance> findByStudent(Student student);
     List<Attendance> findByDate(LocalDate date);
 
} 
    

