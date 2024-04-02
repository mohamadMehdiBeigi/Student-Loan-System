package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.Installment;
import com.example.studentloansystem.entity.enums.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface InstallmentRepository extends JpaRepository<Installment, Long> {

//    List<Object[]> calculateInstallment(Long studentId, LoanType loanType);
//
//    List<Object[]> findPayedInstallments(Long studentId);
//
//    List<Object[]> findNotPayedInstallment(Long studentId);
//
//    Integer nearestInstallmentPayment(Long studentId, LoanType loanType);
//
//    List<Object[]> checkHowToPayInstallment(Long studentId, LoanType loanType, LocalDate desireDate);

}
