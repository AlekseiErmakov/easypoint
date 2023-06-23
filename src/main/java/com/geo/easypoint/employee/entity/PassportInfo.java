package com.geo.easypoint.employee.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passport_infos")
public class PassportInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passport_infos_sequence_generator")
    @SequenceGenerator(name = "passport_infos_sequence_generator", sequenceName = "passport_infos_sequence")
    private Long id;
    private String number;
    private LocalDate birthDate;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private LocalDate issueDate;
    private LocalDate expiredDate;
    private String authority;
}
