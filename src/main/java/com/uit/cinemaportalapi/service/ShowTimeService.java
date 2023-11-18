package com.uit.cinemaportalapi.service;

import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.entity.ShowTime;

import java.util.List;

public interface ShowTimeService {
    List<ShowTime> getShowTimeByID(Long showtimeID);
}
