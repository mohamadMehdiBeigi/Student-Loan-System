package com.example.studentloansystem.service.impl;

import com.example.studentloansystem.service.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Service
@Transactional
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {


}

