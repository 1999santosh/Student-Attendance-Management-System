package com.example.student.service;

import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public Student createStudent(Student student) 
    {
        if (studentRepo.findByRollNumber(student.getRollNumber()).isPresent()) 
        {
            throw new IllegalArgumentException("Roll number already exists!");
        }
        if(studentRepo.findByEmail(student.getEmail()).isPresent())
        {
            throw new IllegalArgumentException("Email id already exists!");
        }
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() 
    {
        return studentRepo.findAll();
    }

    public Student getStudentById(Long id) 
    {
        return studentRepo.findById(id).orElseThrow();
    }

    public Student updateStudent(Long id, Student updatedStudent) 
    {
        Student student = studentRepo.findById(id).orElseThrow();
        student.setName(updatedStudent.getName());
        student.setEmail(updatedStudent.getEmail());
        student.setRollNumber(updatedStudent.getRollNumber());
        return studentRepo.save(student);
    }

    public void deleteStudent(Long id) 
    {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Student with ID " + id + " does not exist!");
        }
    }
}

