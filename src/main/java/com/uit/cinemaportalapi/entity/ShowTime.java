package com.uit.cinemaportalapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SHOW_TIME")
public class ShowTime {
    @Id
    @GeneratedValue(generator = "SHOW_TIME_ID_GENERATOR")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seat", cascade = CascadeType.ALL)
    private List<Seat> seats;



}
