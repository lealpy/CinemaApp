package com.lealpy.cinemaapp.data.utils

import com.lealpy.cinemaapp.data.database.MovieEntity
import com.lealpy.cinemaapp.data.models.MovieData
import com.lealpy.cinemaapp.domain.models.Movie

fun List<MovieData>.toMovieEntities(): List<MovieEntity> {
    return this.map { moviesResult ->
        MovieEntity(
            id = moviesResult.id,
            localizedName = moviesResult.localizedName,
            name = moviesResult.name,
            description = moviesResult.description,
            year = moviesResult.year,
            rating = moviesResult.rating,
            imageUrl = moviesResult.imageUrl,
            genres = moviesResult.genres
        )
    }
}

fun List<MovieEntity>.toMovies(): List<Movie> {
    return this.map { movieEntity ->
        Movie(
            id = movieEntity.id,
            localizedName = movieEntity.localizedName,
            name = movieEntity.name,
            description = movieEntity.description,
            year = movieEntity.year,
            rating = movieEntity.rating,
            imageUrl = movieEntity.imageUrl,
            genres = movieEntity.genres
        )
    }
}

fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = this.id,
        localizedName = this.localizedName,
        name = this.name,
        description = this.description,
        year = this.year,
        rating = this.rating,
        imageUrl = this.imageUrl,
        genres = this.genres
    )
}
