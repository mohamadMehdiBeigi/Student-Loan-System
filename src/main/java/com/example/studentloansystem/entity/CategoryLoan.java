package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.CityPopulation;
import com.example.studentloansystem.entity.enums.EducationLevel;
import com.example.studentloansystem.entity.enums.HowToPayInstallments;
import com.example.studentloansystem.entity.enums.LoanType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "category_loan", schema = "hw16")
@Entity
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_categoryLoan", schema = "hw16")
public class CategoryLoan extends BaseEntity<Long> implements Serializable {

    @Column(name = "loan_price")
    Double loanPrice;

    @Enumerated(value = EnumType.STRING)
    LoanType loanType;

    @Column(name = "city_population")
    @Enumerated(value = EnumType.STRING)
    CityPopulation cityPopulation;

    @Column(name = "education_level")
    @Enumerated(value = EnumType.STRING)
    EducationLevel educationLevel;

    @Column(name = "how_to_pay_installment")
    @Enumerated(value = EnumType.STRING)
    HowToPayInstallments howToPayInstallments;


}
