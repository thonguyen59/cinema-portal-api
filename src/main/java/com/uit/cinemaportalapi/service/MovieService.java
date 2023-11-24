package com.uit.cinemaportalapi.service;

import com.uit.cinemaportalapi.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> findAllByEnableIsTrue();
    List<Movie> findAllMovieComingSon();

}