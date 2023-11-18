package com.uit.cinemaportalapi.controller;

import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.payload.dto.SeatDTO;
import com.uit.cinemaportalapi.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping("/{showTimeID}")
    ResponseEntity<List<Seat>> getSeatByShowTime(@PathVariable(name = "showTimeID") String showTimeID){
        return ResponseEntity.ok(seatService.getSeatByShowTime(Long.valueOf(showTimeID)));
    }
}