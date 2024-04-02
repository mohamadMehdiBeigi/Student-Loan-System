package com.example.studentloansystem.repository;

import com.example.studentloansystem.entity.BankAccount;

import com.example.studentloansystem.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LoanRepository extends JpaRepository<Loan, Long> {

//    boolean LoanRegistration(LocalDate desireDate);
//
//    Double educationLoanCondition(Long studentId, LoanType loanType, Long loanId);
//
//    void depositLoanMoney(Long studentId, String bankAccountNumber, Double loanPrice);
//
//    Double tuitionLoanCondition(Long studentId, LoanType loanType, Long loanId);
//
//    Double mortgageLoanCondition(Long studentId, LoanType loanType, Long loanId);
//
//    Long getLoanCategoryId(Long studentId, LoanType loanType);

}
