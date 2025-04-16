package com.example.student.controller;

import com.example.student.entity.Student;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) 
    {   
        return studentService.createStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) 
    {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) 
    {
        return studentService.updateStudent(id, updatedStudent);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) 
    {
        studentService.deleteStudent(id);
        return "Student deleted successfully!";
    }
}
