package com.geo.easypoint.tool.totalstation.domain;

import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.tool.Tool;
import com.geo.easypoint.tool.state.domain.ToolState;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "total_stations")
public class TotalStation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "total_stations_seq_generator")
    @SequenceGenerator(name = "total_stations_seq_generator", sequenceName = "total_stations_seq")
    private Long id;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "toolStateId")
//    private ToolState state;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "areaStructureId")
//    private AreaStructure areaStructure;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "administrativUnitId")
//    private AdministrativeUnit administrativeUnit;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;
    private String firm;
    private String model;
    private String serialNumber;
//    private LocalDate lastVerificationDate;
//    private LocalDate dateOfPurchase;

//    private Long plummet;
}
