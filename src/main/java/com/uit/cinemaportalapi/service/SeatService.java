package com.uit.cinemaportalapi.service;

import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.payload.dto.SeatDTO;

import java.util.List;

public interface SeatService {
    List<Seat> getSeatByShowTime(Long showTimeID);
}
