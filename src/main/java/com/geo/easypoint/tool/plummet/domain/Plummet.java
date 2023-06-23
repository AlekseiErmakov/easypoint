package com.geo.easypoint.tool.plummet.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "plummets")
public class Plummet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "plummets_seq_generator")
    @SequenceGenerator(name = "plummets_seq_generator", sequenceName = "plummets_seq")
    private Long id;
    private String name;
}
