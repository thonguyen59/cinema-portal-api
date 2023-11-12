package com.uit.cinemaportalapi.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "MOVIE")
public class Movie {
    @Id
    @GeneratedValue(generator = "MOVIE_ID_GENERATOR")
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;

    @Column(name = "MOVIE_CODE", length = 255)
    private String movieCode;

    @Column(name = "TITTLE", length = 255)
    private String title;

    @Column(name = "CATEGORY", length = 255)
    private String category;

    @Column(name = "TRAILER_URL")
    private String trailerURL;

    @Column(name = "POSTER_URL")
    private String posterURL;

    // Độ dài của movie
    @Column(name = "TIME", length = 255)
    private String time;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @Column(name = "RATING", length = 255)
    private String rating;

    @Column(name = "LANGUAGES", length = 255)
    private String languages;

    @Column(name = "DIRECTOR", length = 255)
    private String director;

    @Column(name = "CAST", length = 255)
    private String cast;

    @Column(name = "RELEASE_DATE", length = 255)
    private String releaseDate;
}
