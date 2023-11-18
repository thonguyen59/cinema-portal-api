package com.uit.cinemaportalapi.service.impl;

import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.exception.BadRequestException;
import com.uit.cinemaportalapi.repository.SeatRepository;
import com.uit.cinemaportalapi.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;

    @Override
    public List<Seat> getSeatByShowTime(Long showTimeID) {
        try {
            return seatRepository.findAllByShowTimeId(showTimeID);
        } catch (Exception e) {
            throw new BadRequestException("Can not find seats for show time: " + e.getMessage());
        }
    }
}
