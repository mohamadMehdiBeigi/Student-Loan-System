package com.example.studentloansystem.service;


import com.example.studentloansystem.entity.BankAccount;
import com.example.studentloansystem.entity.enums.LoanType;

import java.time.LocalDate;

public interface BankAccountService  {


    boolean checkingBankAccount(BankAccount bankAccount);
}
