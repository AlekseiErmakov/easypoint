package com.geo.easypoint.tool;


import com.geo.easypoint.administrative.unit.domain.AdministrativeUnit;
import com.geo.easypoint.area.structure.domain.AreaStructure;
import com.geo.easypoint.tool.state.domain.ToolState;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

//@Entity
//@Getter
//@SuperBuilder
//@NoArgsConstructor
//@AllArgsConstructor
//@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Tool {


}
