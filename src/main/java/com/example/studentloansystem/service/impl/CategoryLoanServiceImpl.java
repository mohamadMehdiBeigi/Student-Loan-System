package com.example.studentloansystem.service.impl;

import com.example.studentloansystem.entity.CategoryLoan;
import com.example.studentloansystem.repository.CategoryLoanRepository;
import com.example.studentloansystem.service.CategoryLoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryLoanServiceImpl implements CategoryLoanService {

    private final CategoryLoanRepository categoryLoanRepository;

    @Override
    public List<CategoryLoan> findAllCategoryLoan(){
        return categoryLoanRepository.findAll();
    }


}

