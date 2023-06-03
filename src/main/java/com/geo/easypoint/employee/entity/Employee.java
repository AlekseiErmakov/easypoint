package com.geo.easypoint.employee.entity;

import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.competency.domain.Competency;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence_generator")
    @SequenceGenerator(name = "employee_sequence_generator", sequenceName = "employee_sequence")
    private Long id;
    private String firstname;
    private String surname;
    private String lastname;
    private String phoneNumber;
    private String email;
    private LocalDate hiredDated;
    private LocalDate firedDate;
    @ManyToMany
    @JoinTable(
            name = "employees_administrative_units",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "administrative_unit_id")}
    )
    @Builder.Default
    private Set<AdministrativeUnit> administrativeUnits = new HashSet<>();

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    @JoinColumn(name = "addressId")
    @Builder.Default
    private Address address = new Address();
    @Builder.Default
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true, optional = false)
    @JoinColumn(name = "passportInfoId")
    private PassportInfo passportInfo = new PassportInfo();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competencyId")
    private Competency competency;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jobTitleId")
    private JobTitle jobTitle;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public List<AdministrativeUnit> getAllAdministrativeUnits() {
        Map<Long, AdministrativeUnit> administrativeUnitMap = new HashMap<>();
        for (AdministrativeUnit administrativeUnit : administrativeUnits) {
            while (administrativeUnit != null) {
                administrativeUnitMap.put(administrativeUnit.getId(), administrativeUnit);
                administrativeUnit = administrativeUnit.getParent();
            }
        }
        return new ArrayList<>(administrativeUnitMap.values());
    }

}
