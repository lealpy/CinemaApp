package com.lealpy.cinemaapp.presentation.utils

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.presentation.models.Genre
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

fun List<Genre>.toGenreItems(checkedGenre: Genre): List<RecyclerViewItem.GenreItem> {
    return this.map { genre ->
        RecyclerViewItem.GenreItem(
            id = genre.id,
            genre = genre,
            isChecked = genre == checkedGenre
        )
    }
}
