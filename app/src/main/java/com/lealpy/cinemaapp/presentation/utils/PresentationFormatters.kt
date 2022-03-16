package com.lealpy.cinemaapp.presentation.utils

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem

fun List<Movie>.toMovieItems(): List<RecyclerViewItem.MovieItem> {
    return this.map { movieData ->
        RecyclerViewItem.MovieItem(
            id = movieData.id,
            localizedName = movieData.localizedName,
            name = movieData.name,
            year = movieData.year,
            rating = movieData.rating,
            imageUrl = movieData.imageUrl,
            description = movieData.description,
            genres = movieData.genres,
        )
    }
}