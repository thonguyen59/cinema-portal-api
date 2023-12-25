package com.uit.cinemaportalapi.repository;

import com.uit.cinemaportalapi.entity.Movie;
import com.uit.cinemaportalapi.entity.Seat;
import com.uit.cinemaportalapi.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime,Long > {

    @Query(value = "SELECT * FROM SHOW_TIME WHERE MOVIE_ID = :id AND END_TIME >= :currentDate ORDER BY START_TIME ASC ", nativeQuery = true)
    List<ShowTime> findAllByMovieAndEndTime(Long id, LocalDate currentDate);

    List<ShowTime> findAllByMovie(Movie movie);
}