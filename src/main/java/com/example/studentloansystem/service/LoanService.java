package com.example.studentloansystem.service;


import java.time.LocalDate;

public interface LoanService  {

    boolean checkOpeningLoansDate(LocalDate localDate);
}
