package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {

    Double payMonthlyInstallment(Long studentId, BankAccount bankAccount, Integer paymentNumber);
}
