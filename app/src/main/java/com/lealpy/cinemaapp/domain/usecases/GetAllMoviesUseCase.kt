package com.lealpy.cinemaapp.domain.usecases

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetAllMoviesUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
) {

    suspend operator fun invoke(): List<Movie> {
        return moviesRepository.getAllMovies()
    }

}
