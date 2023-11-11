package com.uit.cinemaportalapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "CINEMA")
public class Cinema {
    @Id
    @GeneratedValue(generator = "CINEMA_ID_GENERATOR")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
}
