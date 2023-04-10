package com.geo.easypoint.administrative.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;
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

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(
        name = "admin-structure-graph",
        attributeNodes = {
                @NamedAttributeNode("administrativeUnitType"),
                @NamedAttributeNode("children"),
                @NamedAttributeNode("parent")
        }
)
@Table(name = "administrative_units")
public class AdministrativeUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "administrative_units_generator")
    @SequenceGenerator(name = "administrative_units_generator", sequenceName = "administrative_units_seq", allocationSize = 1)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "administrativeUnitTypeId")
    private AdministrativeUnitType administrativeUnitType;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentAdministrativeUnitId")
    private AdministrativeUnit parent;

    @Builder.Default
    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<AdministrativeUnit> children = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
