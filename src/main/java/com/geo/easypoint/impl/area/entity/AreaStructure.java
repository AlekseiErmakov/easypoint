package com.geo.easypoint.impl.area.entity;


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
import org.springframework.boot.context.properties.bind.Name;

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
        name = "area-structure-graph",
        attributeNodes = {
                @NamedAttributeNode("areaStructureType"),
                @NamedAttributeNode("children"),
                @NamedAttributeNode("parent")
        }
)
@Table(name = "area_structures")
public class AreaStructure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "area_structures_generator")
    @SequenceGenerator(name = "area_structures_generator", sequenceName = "area_structures_seq", allocationSize = 1)
    private Long id;

    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "areaStructureTypeId")
    private AreaStructureType areaStructureType;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentAreaStructureId")
    private AreaStructure parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
    private Set<AreaStructure> children = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
}
