package com.uit.cinemaportalapi.repository;

import com.uit.cinemaportalapi.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie , Long> {
    List<Movie> findAllByEnableIsTrueAndReleaseDateGreaterThanEqualOrderByReleaseDateAsc(Date currentDate);

    List<Movie>  findAllByEnableIsTrue();

    List<Movie> findAllByEnableIsTrueAndReleaseDateOrderByReleaseDate(Date currentDate);



}