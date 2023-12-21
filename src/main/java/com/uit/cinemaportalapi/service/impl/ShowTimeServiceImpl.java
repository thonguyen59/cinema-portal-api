package com.uit.cinemaportalapi.service.impl;

import com.uit.cinemaportalapi.entity.Movie;
import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.entity.ShowTime;
import com.uit.cinemaportalapi.exception.BadRequestException;
import com.uit.cinemaportalapi.payload.CreateShowTimeRequest;
import com.uit.cinemaportalapi.repository.SeatRepository;
import com.uit.cinemaportalapi.repository.ShowTimeRepository;
import com.uit.cinemaportalapi.service.MovieService;
import com.uit.cinemaportalapi.service.SeatService;
import com.uit.cinemaportalapi.service.ShowTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ShowTimeServiceImpl implements ShowTimeService {

    @Autowired
    ShowTimeRepository showtimeRepository;

    @Autowired
    MovieService movieService;

    @Autowired
    SeatService seatService;


    @Override
    public List<ShowTime> getShowTimeByID(Long ID) {
        try {
            return showtimeRepository.findAllById(Collections.singleton(ID));
        } catch (Exception e) {
            throw new BadRequestException("Can not find seats for show time: " + e.getMessage());
        }
    }

    @Override
    public List<ShowTime> getShowTimeByMovie(Long movieID) {
        try {
            Movie movie = movieService.findMovieByID(movieID);
            return showtimeRepository.findAllByMovie(movie);
        } catch (Exception e) {
            throw new BadRequestException("Can not find showtimes: " + e.getMessage());
        }
    }

    @Override
    public ShowTime createShowTimeByMovie(CreateShowTimeRequest request) {
        try {
            ShowTime showTime = new ShowTime();

            showTime.setStartTime(request.getStartTime());
            showTime.setEndTime(request.getEndTime());

            Movie movie = movieService.findMovieByID(request.getMovieID());
            showTime.setMovie(movie);

            showTime.setCinemaName(request.getCinemaName());

            ShowTime showtimeSaved = showtimeRepository.save(showTime);

            List<Seat> seats = seatService.createSeatsForShowTime(showtimeSaved);
            showtimeSaved.setSeats(seats);

            showtimeRepository.save(showtimeSaved);

            return showTime;
        } catch (Exception e) {
            throw new BadRequestException("Can not find showtimes: " + e.getMessage());
        }
    }
}
