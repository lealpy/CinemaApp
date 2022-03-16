package com.lealpy.cinemaapp.domain.usecases

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetMovieByIdUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
) {

    suspend operator fun invoke(movieId: Int): Movie {
        return moviesRepository.getMovieById(movieId = movieId)
    }

}
