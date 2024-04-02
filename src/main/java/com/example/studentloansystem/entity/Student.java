package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.AcceptanceType;
import com.example.studentloansystem.entity.enums.EducationLevel;
import com.example.studentloansystem.entity.enums.EducationStatus;
import com.example.studentloansystem.entity.enums.MarriageStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "student", schema = "loan_system")
@Entity
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_student", schema = "loan_system")
public class Student extends BaseEntity<Long> implements Serializable {

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "firstname must have been include just English alphabet")
    String firstname;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "lastname must have been include just English alphabet")
    String lastname;

    String password;

    @Column(name = "fathers_name", nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "fathers name must have been include just English alphabet")
    String fathersName;

    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "mothers name must have been include just English alphabet")
    @Column(name = "mothers_name", nullable = false)
    String mothersName;

    @Column(name = "birthDate_certificate_ID", nullable = false)
    @Pattern(regexp = "^\\d+$", message = "birth Certificate Id only accept numbers")
    String birthCertificateId;

    @Column(name = "national_code", unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "nationalCode must have been only 10 digits and only number")
    String nationalCode;

    @Column(name = "birth_date", nullable = false)
    LocalDate birthDate;

    @Column(name = "university_name", nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "university Name must have been include just English alphabet")
    String universityName;

    @Column(name = "year_of_entrance", nullable = false)
    LocalDate yearOfEntrance;

    @Column(name = "education_level", nullable = false)
    @Enumerated(value = EnumType.STRING)
    EducationLevel educationLevel;

    @Column(name = "acceptance_type", nullable = false)
    @Enumerated(value = EnumType.STRING)
    AcceptanceType acceptanceType;

    @Column(name = "martial_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    MarriageStatus marriageStatus;

    @OneToOne
    Spouse spouse;

    @Column(name = "residence_address", nullable = false)
    String residenceAddress;

    @Column(name = "education_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    EducationStatus educationStatus;

    @Column(name = "student_dormitory", nullable = false)
    boolean studentDormitory;

    @ManyToOne
    City city;

//    @PrePersist
//    @PreUpdate
//    private void preparePassword() {
//        if (password == null || password.isEmpty()) {
//            PasswordGenerator generator = new PasswordGenerator(8);
//            this.password = generator.nextPassword();
//        }
//    }
}
