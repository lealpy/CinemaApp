package com.lealpy.cinemaapp.domain.usecases

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class GetMoviesByGenreUseCase @Inject constructor(
    private val moviesRepository: MoviesRepository,
) {

    suspend operator fun invoke(genreName: String): List<Movie> {
        return moviesRepository.getMoviesByGenre(genreName = genreName).sortedBy { movie ->
            movie.localizedName
        }
    }

}
