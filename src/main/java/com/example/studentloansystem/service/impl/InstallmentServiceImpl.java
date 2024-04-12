package com.example.studentloansystem.service.impl;

import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.entity.Installment;
import com.example.studentloansystem.entity.Loan;
import com.example.studentloansystem.entity.Student;
import com.example.studentloansystem.entity.enums.EducationLevel;
import com.example.studentloansystem.entity.enums.LoanType;
import com.example.studentloansystem.entity.enums.PaymentStatus;
import com.example.studentloansystem.repository.InstallmentRepository;
import com.example.studentloansystem.service.CategoryLoanService;
import com.example.studentloansystem.service.InstallmentService;


import com.example.studentloansystem.service.LoanService;
import com.example.studentloansystem.service.StudentService;
import jakarta.persistence.NoResultException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class InstallmentServiceImpl implements InstallmentService {

    private final CategoryLoanService categoryLoanService;
    private final InstallmentRepository installmentRepository;
    private final LoanService loanService;
    private final StudentService studentService;

    @Override
    public List<Installment> seeAllLInstallmentByStudentId(Long studentId) {
        List<Installment> installmentList = installmentRepository.seeAllInstallment(studentId);
        if (installmentList.size() == 0) {
            throw new NoResultException("you haven't take any loan now");
        }
        return installmentList;
    }

    @Override
    public void calculateInstallment(Long studentId, LoanType loanType) {
        Student student = studentService.findById(studentId);

        CategoryLoan categoryLoan;
        if (loanType == LoanType.HOUSING_LOAN) {
            categoryLoan = loanService.chooseHousingLoan(studentId);
        } else {
            categoryLoan = loanService.chooseTuitionAndEducationLoan(studentId, loanType);
        }
        Loan loan = loanService.findByCategoryLoanIdAndStudentId(categoryLoan.getId(), studentId);

        LocalDate yearOfEntrance = student.getYearOfEntrance();
        EducationLevel educationLevel = student.getEducationLevel();

        double afterProfitPercent = categoryLoan.getLoanPrice() * 1.04;
        double firstInstallment = afterProfitPercent / 372;

        LocalDate firstDateOfDeposit = null;
        if (educationLevel == EducationLevel.ASSOCIATE
                || educationLevel == EducationLevel.DISCONTINUOUS_MASTER
                || educationLevel == EducationLevel.CONTINUOUS_DOCTORATE
                || educationLevel == EducationLevel.PROFESSIONAL_DOCTORATE
                || educationLevel == EducationLevel.DISCONTINUOUS_SPECIALIZED_DOCTORATE) {
            firstDateOfDeposit = yearOfEntrance.plusYears(2);

        } else if (educationLevel == EducationLevel.CONTINUOUS_BACHELORS
                || educationLevel == EducationLevel.DISCONTINUOUS_BACHELORS) {
            firstDateOfDeposit = yearOfEntrance.plusYears(4);

        } else if (educationLevel == EducationLevel.CONTINUOUS_MASTERS) {
            firstDateOfDeposit = yearOfEntrance.plusYears(6);

        }
        Installment installment = new Installment();
        int count1 = 1;
        int i = 1;
        while (count1 <= 60) {

            installment.setAmountOfInstallment(firstInstallment);
            assert firstDateOfDeposit != null;
            installment.setDateOfPayment(firstDateOfDeposit.plusMonths(i));
            installment.setPaymentNumber(i);
            installment.setPaymentStatus(PaymentStatus.NOT_PAYED);
            installment.setLoan(loan);
            installmentRepository.save(installment);
            count1++;
            i++;
            if (count1 == 13 || count1 == 25 || count1 == 37 || count1 == 49 || count1 == 61) {
                firstInstallment = firstInstallment * 2;
            }
        }
    }
}

