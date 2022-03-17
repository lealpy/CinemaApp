package com.lealpy.cinemaapp.presentation.screens.details

import com.lealpy.cinemaapp.domain.models.Movie

interface DetailsInterface {

    interface DetailsPresenterInterface {
        fun viewCreated(movieId: Int)
        fun viewDestroyed()
    }

    interface DetailsViewInterface {
        fun updateMovie(movie: Movie)
        fun showProgress()
        fun hideProgress()
    }

}
