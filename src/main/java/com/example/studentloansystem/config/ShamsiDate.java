package com.example.studentloansystem.config;

import com.github.eloyzone.jalalicalendar.DateConverter;
import com.github.eloyzone.jalalicalendar.JalaliDate;

import java.time.LocalDate;

public class ShamsiDate {

    public static LocalDate shamsiToGregorian(int year, int month, int day) {
        DateConverter date = new DateConverter();
        return date.jalaliToGregorian(year, month, day);
    }

    public static JalaliDate gregorianToShamsi(LocalDate localDate) {
        DateConverter date = new DateConverter();
        return date.gregorianToJalali(localDate.getYear(), localDate.getMonth(), localDate.getDayOfMonth());
    }

}


