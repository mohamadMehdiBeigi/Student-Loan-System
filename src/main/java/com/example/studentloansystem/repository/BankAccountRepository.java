package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    BankAccount findByBankAccountNumberAndCvv2AndExpiryDate(String bankAccountNumber, Integer cvv2, LocalDate expiryDate);
}
