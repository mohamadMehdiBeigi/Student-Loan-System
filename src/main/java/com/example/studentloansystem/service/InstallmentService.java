package com.example.studentloansystem.service;


import com.example.studentloansystem.entity.Installment;
import com.example.studentloansystem.entity.enums.LoanType;

import java.time.LocalDate;
import java.util.List;

public interface InstallmentService  {


    List<Installment> seeAllLInstallmentByStudentId(Long studentId);

    void calculateInstallment(Long studentId, LoanType loanType);
}
