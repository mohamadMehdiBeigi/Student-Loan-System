package com.example.studentloansystem.service.impl;


import com.example.studentloansystem.config.exceptions.NotFoundException;
import com.example.studentloansystem.entity.Student;
import com.example.studentloansystem.repository.StudentRepository;
import com.example.studentloansystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student findById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("there is no account with this id"));
    }

}
