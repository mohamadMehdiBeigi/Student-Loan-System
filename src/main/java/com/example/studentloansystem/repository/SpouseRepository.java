package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.BankAccount;
import com.example.studentloansystem.entity.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpouseRepository extends JpaRepository<BankAccount, Long> {
//    Long findIdByNationalCode(Spouse spouse);
}
