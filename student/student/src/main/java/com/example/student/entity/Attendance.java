package com.example.student.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class Attendance 
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_rollNumber", referencedColumnName = "rollNumber")
    private Student student;

    @NotBlank(message = "Status is required")
    private String status; // "Present" or "Absent"
}
