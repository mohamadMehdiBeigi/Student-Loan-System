package com.example.studentloansystem.service;



import com.example.studentloansystem.entity.Student;

import java.time.LocalDate;
import java.util.List;

public interface StudentService {

    Student findById(Long studentId);

    boolean graduateChecking(Long studentId);

    void graduateInTime(Long studentId);
}
