package com.example.studentloansystem.service.impl;


import com.example.studentloansystem.config.ShamsiDate;
import com.example.studentloansystem.service.LoanService;
import com.github.eloyzone.jalalicalendar.JalaliDate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class LoanServiceImpl implements LoanService {


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
}
