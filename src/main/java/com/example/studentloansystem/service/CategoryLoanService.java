package com.example.studentloansystem.service;


import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.entity.Loan;

import java.util.List;

public interface CategoryLoanService {

    List<CategoryLoan> findAllCategoryLoan();
}
