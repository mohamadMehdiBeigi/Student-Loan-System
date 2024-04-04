package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.BankAccount;
import com.example.studentloansystem.entity.Spouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpouseRepository extends JpaRepository<Spouse, Long> {

}
