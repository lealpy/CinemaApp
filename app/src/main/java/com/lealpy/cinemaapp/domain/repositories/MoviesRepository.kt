package com.lealpy.cinemaapp.domain.repositories

import com.lealpy.cinemaapp.domain.models.Movie

interface MoviesRepository {

    suspend fun getAllMovies(): List<Movie>
    suspend fun getCharacterById(movieId: Int): Movie

}