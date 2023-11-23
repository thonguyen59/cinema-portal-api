package com.uit.cinemaportalapi.repository;

import com.uit.cinemaportalapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Long , Movie> {

    @Query(value = "SELECT u FROM MOVIE WHERE u.enable = true" ,nativeQuery = true )
    List<Movie> findAllMovieEnable ();

    List<Movie> findAllByEnableIsTrue();



}