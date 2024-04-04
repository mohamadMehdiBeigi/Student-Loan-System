package com.example.studentloansystem.service;


import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.entity.Loan;
import com.example.studentloansystem.entity.enums.LoanType;

import java.time.LocalDate;

public interface LoanService  {

    Loan findByCategoryLoanIdAndStudentId(Long categoryLoanId, Long studentId);

    boolean checkOpeningLoansDate(LocalDate localDate);


    CategoryLoan chooseHousingLoan(Long studentId);

    CategoryLoan chooseTuitionAndEducationLoan(Long studentId, LoanType loanType);
}
