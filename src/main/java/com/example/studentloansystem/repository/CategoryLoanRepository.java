package com.example.studentloansystem.repository;

import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryLoanRepository extends JpaRepository<CategoryLoan, Long> {

    @Query("""
            select CategoryLoan\s
            from Loan l\s
            join l.categoryLoan\s
            where l.student.id =:studentId
            """)
    public List<CategoryLoan> findAllByStudentId(Long studentId);
}
