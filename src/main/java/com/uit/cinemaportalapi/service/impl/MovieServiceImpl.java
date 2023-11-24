package com.uit.cinemaportalapi.service.impl;


import com.uit.cinemaportalapi.entity.Movie;
import com.uit.cinemaportalapi.exception.BadRequestException;
import com.uit.cinemaportalapi.repository.MovieRepository;
import com.uit.cinemaportalapi.service.MovieService;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> findAllByEnableIsTrue() {
        try {
            Date currentDate = new Date();
            return movieRepository.findAllByEnableIsTrue();
        } catch (Exception e) {
            throw new BadRequestException("Can not find Movie: " + e.getMessage());
        }
    }

    @Override
    public List<Movie> findAllMovieComingSon() {
        try {
            Date currentDate = new Date();

            return movieRepository.findAllByEnableIsTrueAndReleaseDate(currentDate);
        } catch (Exception e) {
            throw new BadRequestException("Can not find Movie: " + e.getMessage());
        }
    }

}
