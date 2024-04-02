package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "loan_system")
@Entity
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_installment", schema = "loan_system")
public class Installment extends BaseEntity<Long> implements Serializable {

    @Column(name = "amount_of_installment")
    Double amountOfInstallment;

    @Column(name = "payment_number")
    Integer paymentNumber;

    @Column(name = "date_of_payment")
    LocalDate dateOfPayment;

    @Column(name = "date_of_deposit")
    LocalDate dateOfDeposit;

    @Column(name = "payment_status")
    @Enumerated(value = EnumType.STRING)
    PaymentStatus paymentStatus;


    @ManyToOne
    Loan loan;

}
