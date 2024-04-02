package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.BankName;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "hw16")
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_card_number", schema = "hw16")
public class BankAccount extends BaseEntity<Long> implements Serializable {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "bank_name", nullable = false)
    BankName bankName;

    @Column(name = "bank_account_number", nullable = false)
    @Pattern(regexp = "^(603799|589463|627353|628023)\\d{10}$", message = "either this bank is not exist nor you must enter 16 number")
    String bankAccountNumber;

    @Column(name = "CVV2", nullable = false)
    Integer cvv2;

    @Column(name = "expiry_date", nullable = false)
    LocalDate expiryDate;

    Double balance;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;


}
