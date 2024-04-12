package com.example.studentloansystem.service.impl;


import com.example.studentloansystem.config.exceptions.NotFoundException;
import com.example.studentloansystem.entity.Student;
import com.example.studentloansystem.entity.enums.EducationLevel;
import com.example.studentloansystem.entity.enums.EducationStatus;
import com.example.studentloansystem.repository.StudentRepository;
import com.example.studentloansystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student findById(Long studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("there is no account with this id"));
    }

    @Override
    public boolean graduateChecking(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("this id is not exist"));
        return student.getEducationStatus() == EducationStatus.GRADUATED;
    }

    @Override
    public void graduateInTime(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new NotFoundException("this id is not exist"));
        LocalDate yearsOfEntrance = student.getYearOfEntrance();
        EducationLevel educationLevel = student.getEducationLevel();

        Student newStudent = new Student();
        boolean graduate = false;
        if ((educationLevel == EducationLevel.ASSOCIATE
                || educationLevel == EducationLevel.DISCONTINUOUS_MASTER)
                && ((LocalDate.now().isAfter(yearsOfEntrance.plusYears(2))
                || LocalDate.now().isEqual(yearsOfEntrance.plusYears(2))))) {
            graduate = true;

        } else if ((educationLevel == EducationLevel.DISCONTINUOUS_BACHELORS
                || educationLevel == EducationLevel.CONTINUOUS_BACHELORS)
                && ((LocalDate.now().isAfter(yearsOfEntrance.plusYears(4))
                || LocalDate.now().isEqual(yearsOfEntrance.plusYears(4))))) {
            graduate = true;

        } else if ((educationLevel == EducationLevel.PROFESSIONAL_DOCTORATE
                || educationLevel == EducationLevel.CONTINUOUS_DOCTORATE
                || educationLevel == EducationLevel.DISCONTINUOUS_SPECIALIZED_DOCTORATE)
                && ((LocalDate.now().isAfter(yearsOfEntrance.plusYears(5))
                || LocalDate.now().isEqual(yearsOfEntrance.plusYears(5))))) {
            graduate = true;

        } else if (educationLevel == EducationLevel.CONTINUOUS_MASTERS
                && (LocalDate.now().isAfter(yearsOfEntrance.plusYears(6))
                || LocalDate.now().isEqual(yearsOfEntrance.plusYears(6)))) {
            graduate = true;

        }
        if (graduate) {
            newStudent.setEducationStatus(EducationStatus.GRADUATED);
            studentRepository.save(newStudent);

        }
    }

}
