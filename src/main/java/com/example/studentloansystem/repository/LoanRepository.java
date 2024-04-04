package com.example.studentloansystem.repository;

import com.example.studentloansystem.entity.BankAccount;

import com.example.studentloansystem.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

    Loan findByCategoryLoanIdAndStudentId(Long categoryLoanId, Long studentId);

}
