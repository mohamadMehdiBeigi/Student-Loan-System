package com.example.studentloansystem.entity;

import com.example.studentloansystem.entity.baseEntity.BaseEntity;
import com.example.studentloansystem.entity.enums.CityPopulation;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "city", schema = "hw16")
@Entity
@SequenceGenerator(name = "ID_GENERATOR", allocationSize = 1, sequenceName = "seq_student", schema = "hw16")
public class City extends BaseEntity<Long> implements Serializable {

    @Column(name = "city_name", unique = true)
    String cityName;

    @Column(name = "city_population")
    @Enumerated(EnumType.STRING)
    CityPopulation cityPopulation;


}
