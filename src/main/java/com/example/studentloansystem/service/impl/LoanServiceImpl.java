package com.example.studentloansystem.service.impl;


import com.example.studentloansystem.config.ShamsiDate;
import com.example.studentloansystem.config.exceptions.BadRequestException;
import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.entity.Loan;
import com.example.studentloansystem.entity.Student;
import com.example.studentloansystem.entity.enums.CityPopulation;
import com.example.studentloansystem.entity.enums.EducationLevel;
import com.example.studentloansystem.entity.enums.LoanType;
import com.example.studentloansystem.repository.LoanRepository;
import com.example.studentloansystem.service.CategoryLoanService;
import com.example.studentloansystem.service.LoanService;
import com.example.studentloansystem.service.StudentService;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {

    private final StudentService studentService;
    private final LoanRepository loanRepository;
    private final CategoryLoanService categoryLoanService;

    @Override
    public Loan findByCategoryLoanIdAndStudentId(Long categoryLoanId, Long studentId){
        return loanRepository.findByCategoryLoanIdAndStudentId(categoryLoanId, studentId);
    }

    @Override
    public boolean checkOpeningLoansDate(LocalDate localDate) {
        JalaliDate jalaliDate = ShamsiDate.gregorianToShamsi(localDate);

        LocalDate abanFirstDate = ShamsiDate.shamsiToGregorian(jalaliDate.getYear(), 7, 30);
        LocalDate abanLastDate = ShamsiDate.shamsiToGregorian(jalaliDate.getYear(), 8, 8);
        LocalDate bahmanFirstDate = ShamsiDate.shamsiToGregorian(jalaliDate.getYear(), 11, 24);
        LocalDate bahmanLastDate = ShamsiDate.shamsiToGregorian(jalaliDate.getYear(), 12, 2);

        return localDate.isAfter(abanFirstDate) && localDate.isBefore(abanLastDate) ||
                localDate.isAfter(bahmanFirstDate) && localDate.isBefore(bahmanLastDate);
    }

    @Override
    public CategoryLoan chooseHousingLoan(Long studentId) {
        Student student = studentService.findById(studentId);
        String cityName = student.getCity().getCityName();
        CityPopulation cityPopulation = null;
        String[] cities = {
                "AZARBAYJAN_SHARGHI", "AZARBAYJAN_GHARBI", "ARDEBIL", "ESFEHAN", "GILAN", "FARS", "KHOOZESTAN", "GHOM", "KHORASAN_RAZAVI", "ALBORZ", "SEMNAN", "KORDESTAN", "KERMAN", "HAMEDAN"
        };
        boolean cityFound = false;
        for (String c : cities) {
            if (c.equalsIgnoreCase(cityName)) {
                cityPopulation = CityPopulation.BIG_CITIES;
                cityFound = true;
                break;
            }
        }
        if (!cityFound && cityName.equalsIgnoreCase("tehran")) {
            cityPopulation = CityPopulation.TEHRAN;
        } else if (!cityFound) {
            cityPopulation = CityPopulation.OTHER_CITIES;
        }

        List<CategoryLoan> allCategoryLoan = categoryLoanService.findAllCategoryLoan();

        CategoryLoan categoryLoan = null;
        for (CategoryLoan cl : allCategoryLoan) {
            if (cityPopulation == cl.getCityPopulation()) {
                categoryLoan = cl;
            }
        }
        if (categoryLoan != null) {
            Student newStudent = new Student();
            newStudent.setId(studentId);
            Loan loan = new Loan(60, newStudent, categoryLoan);
            loanRepository.save(loan);
        }
        return categoryLoan;
    }
    @Override
    public CategoryLoan chooseTuitionAndEducationLoan(Long studentId, LoanType loanType){
        if (loanType == LoanType.HOUSING_LOAN){
            throw new BadRequestException("you must have choose tuition or education loan type");
        }
        Student student = studentService.findById(studentId);
        EducationLevel educationLevel = student.getEducationLevel();

        List<CategoryLoan> allCategoryLoan = categoryLoanService.findAllCategoryLoan();

        CategoryLoan categoryLoan = null;
        for (CategoryLoan cl: allCategoryLoan) {
            if (educationLevel == cl.getEducationLevel() &&
                    cl.getLoanType() == loanType){
                categoryLoan = cl;
            }
        }
        if (categoryLoan != null) {
            Student newStudent = new Student();
            newStudent.setId(studentId);
            Loan loan = new Loan(60, newStudent, categoryLoan);
            loanRepository.save(loan);
        }
        return categoryLoan;
    }

}
