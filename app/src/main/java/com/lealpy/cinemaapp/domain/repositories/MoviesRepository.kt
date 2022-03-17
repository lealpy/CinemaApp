package com.lealpy.cinemaapp.domain.repositories

import com.lealpy.cinemaapp.domain.models.Movie

interface MoviesRepository {

    suspend fun getAllMovies(): List<Movie>
    suspend fun getMoviesByGenre(genreName: String): List<Movie>
    suspend fun getMovieById(movieId: Int): Movie

}
