package com.example.studentloansystem.repository;



import com.example.studentloansystem.entity.BankAccount;
import com.example.studentloansystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<BankAccount, Long> {

//    EducationStatus checkEducationStatusById(Long studentId);
//
//    LocalDate EducationLevelUp(Long studentId, LocalDate desiredDate);
//
//    List<Student> findByUser(String nationalCode, String password);
//
//    Long getIdFromUsername(String nationalCode, String password);

}
