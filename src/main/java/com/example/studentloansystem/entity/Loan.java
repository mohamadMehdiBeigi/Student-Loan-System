package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "loan_system")
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_loan", schema = "loan_system")
public class Loan extends BaseEntity<Long> implements Serializable {

    @Column(name = "number_of_loan_instalment")
    Integer NumberOfLoanInstallments;

    @ManyToOne
    Student student;

    @ManyToOne
    CategoryLoan categoryLoan;

}
