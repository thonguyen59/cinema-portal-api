package com.uit.cinemaportalapi.controller;

import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.entity.ShowTime;
import com.uit.cinemaportalapi.service.SeatService;
import com.uit.cinemaportalapi.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/showtime")
public class ShowTimeController {

    @Autowired
    private ShowTimeService showtimeService;

    @GetMapping("/{showtimeID}")
    ResponseEntity<List<ShowTime>> getShowTime(@PathVariable(name = "showtimeID") String showtimeID){
        return ResponseEntity.ok(showtimeService.getShowTimeByID(Long.valueOf(showtimeID)));
    }
}