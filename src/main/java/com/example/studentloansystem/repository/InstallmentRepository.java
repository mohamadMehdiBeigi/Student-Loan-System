package com.example.studentloansystem.repository;


import com.example.studentloansystem.entity.Installment;
import com.example.studentloansystem.entity.enums.LoanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface InstallmentRepository extends JpaRepository<Installment, Long> {

    @Query("""
             from Installment i\s
             join i.loan.student s\s
             where s.id =:studentId
            """)
    List<Installment> seeAllInstallment(Long studentId);
}
