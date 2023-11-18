package com.uit.cinemaportalapi.payload.dto;

import com.uit.cinemaportalapi.entity.ShowTime;
import com.uit.cinemaportalapi.entity.Ticket;

public class SeatDTO {
    private Long id;
    private String type;
    private Integer number;
    private Integer row;
    private Boolean isBooked;
}
