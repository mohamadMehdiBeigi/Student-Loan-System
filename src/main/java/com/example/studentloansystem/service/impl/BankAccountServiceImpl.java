package com.example.studentloansystem.service.impl;

import com.example.studentloansystem.entity.BankAccount;
import com.example.studentloansystem.repository.BankAccountRepository;
import com.example.studentloansystem.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;

    @Override
    public boolean checkingBankAccount(BankAccount bankAccount){
        BankAccount findBankAccount = bankAccountRepository.findByBankAccountNumberAndCvv2AndExpiryDate(bankAccount.getBankAccountNumber(), bankAccount.getCvv2(), bankAccount.getExpiryDate());
        return findBankAccount != null;
    }
}

