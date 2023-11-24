package com.uit.cinemaportalapi.controller;

import com.uit.cinemaportalapi.entity.Movie;
import com.uit.cinemaportalapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/enable")
    ResponseEntity<List<Movie>> findAllByEnableIsTrue (){
        return ResponseEntity.ok(movieService.findAllByEnableIsTrue());
    }
    @GetMapping("/coming-son")
    ResponseEntity<List<Movie>> findAllMovieComingSon(){
        return ResponseEntity.ok(movieService.findAllMovieComingSon());
    }
    @GetMapping("/now-showing")
    ResponseEntity<List<Movie>> findAllNowShowing(){
        return ResponseEntity.ok(movieService.findAllMovieNowShowing());
    }
}
