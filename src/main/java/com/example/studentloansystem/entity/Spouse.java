package com.example.studentloansystem.entity;


import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.EducationStatus;
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
@Table(name = "spouse", schema = "hw16")
@Entity
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_spouse", schema = "hw16")
public class Spouse extends BaseEntity<Long> implements Serializable {
    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "firstname must have been include just English alphabet")
    String firstname;

    @Column(nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "lastname must have been include just English alphabet")
    String lastname;

    @Column(name = "fathers_name", nullable = false)
    @Pattern(regexp = "^[A-Za-z]+(?:\\s[A-Za-z]+)*$", message = "fathers name must have been include just English alphabet")
    String fathersName;

    @Column(name = "birthDate_certificate_ID", nullable = false)
    String birthCertificateId;

    @Column(name = "national_code", unique = true)
    @Pattern(regexp = "^\\d{10}$", message = "nationalCode must have been only 10 digits and only number")
    String nationalCode;

    @Column(name = "birth_date", nullable = false)
    LocalDate birthDate;

    @Column(name = "education_status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    EducationStatus educationStatus;

    @OneToOne(mappedBy = "spouse")
    Student student;


}
