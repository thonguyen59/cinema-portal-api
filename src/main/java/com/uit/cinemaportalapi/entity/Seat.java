package com.uit.cinemaportalapi.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(generator = "SEAT_ID_GENERATOR")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "TYPE", length = 255)
    private String type;

    @Column(name = "NUMBER", length = 2)
    private Integer number;

    @Column(name = "ROW", length = 1)
    private String row;

    @Column(name = "BOOKED", length = 1)
    private Boolean isBooked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOW_TIME_ID")
    private ShowTime showTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;
}
