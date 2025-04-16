package com.example.student.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.entity.Attendance;
import com.example.student.entity.Student;
import com.example.student.repository.AttendanceRepository;
import com.example.student.repository.StudentRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepo;

    @Autowired
    private StudentRepository studentRepo;

     public Attendance markAttendance(String studentId, String status) {
        Student student = studentRepo.findByRollNumber(studentId).orElseThrow();
        Attendance attendance = new Attendance();
        attendance.setStudent(student);
        attendance.setStatus(status);
        attendance.setDate(LocalDate.now());
        return attendanceRepo.save(attendance);
    }

    public List<Attendance> getAttendanceByStudent(String studentId) {
        Student student = studentRepo.findByRollNumber(studentId).orElseThrow();
        return attendanceRepo.findByStudent(student);
    }

    public List<Attendance> getAttendanceByDate(LocalDate date) {
        return attendanceRepo.findByDate(date);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }
    
}
