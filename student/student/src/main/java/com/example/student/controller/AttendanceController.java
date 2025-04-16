package com.example.student.controller;

import com.example.student.data_tranfer_object.AttendanceRequest;
import com.example.student.entity.Attendance;
import com.example.student.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @PostMapping("/mark")
    public Attendance markAttendance(@RequestBody AttendanceRequest request) {
    return attendanceService.markAttendance(request.getStudentId(), request.getStatus());
}

    @GetMapping("/student/{studentId}")
    public List<Attendance> getAttendanceByStudent(@PathVariable String studentId) {
        return attendanceService.getAttendanceByStudent(studentId);
    }

    @GetMapping("/date")
    public List<Attendance> getAttendanceByDate(@RequestParam String date) {
        return attendanceService.getAttendanceByDate(LocalDate.parse(date));
    }

    @GetMapping("/all")
    public List<Attendance> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }
}
