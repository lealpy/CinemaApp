package com.lealpy.cinemaapp.data.repositories

import android.util.Log
import com.lealpy.cinemaapp.data.api.MoviesApi
import com.lealpy.cinemaapp.data.database.MoviesDao
import com.lealpy.cinemaapp.data.utils.Const.APP_LOG_TAG
import com.lealpy.cinemaapp.data.utils.toMovie
import com.lealpy.cinemaapp.data.utils.toMovieEntities
import com.lealpy.cinemaapp.data.utils.toMovies
import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.domain.repositories.MoviesRepository
import javax.inject.Inject

class MoviesRepositoryImpl @Inject constructor(
    private val moviesApi: MoviesApi,
    private val moviesDao: MoviesDao,
) : MoviesRepository {

    override suspend fun getAllMovies(): List<Movie> {
        try {
            val movieEntities = moviesApi.getAllMovies()
                .films
                .toMovieEntities()
            moviesDao.insertMovieEntities(movieEntities)
        } catch (e: Exception) {
            Log.e(APP_LOG_TAG, e.message.toString())
        }

        return moviesDao.getAllMovieEntities().toMovies()
    }

    override suspend fun getCharacterById(movieId: Int): Movie {
        return moviesDao.getMovieEntityById(movieId).toMovie()
    }

}
