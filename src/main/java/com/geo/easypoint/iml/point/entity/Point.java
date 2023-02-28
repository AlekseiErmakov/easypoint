package com.geo.easypoint.iml.point.entity;

import com.geo.easypoint.iml.employee.entity.Employee;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "points")
@NamedEntityGraph(
        name = "point-entity-graph",
        attributeNodes = {
                @NamedAttributeNode("creator"),
                @NamedAttributeNode("pointType"),
                @NamedAttributeNode("pointState")
        }
)
public class Point {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "point_sequence_generator")
    @SequenceGenerator(name = "point_sequence_generator", sequenceName = "point_seq")
    private Long id;
    private String name;
    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal h;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee creator;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_type_id")
    private PointType pointType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "point_state_id")
    private PointState pointState;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
}
