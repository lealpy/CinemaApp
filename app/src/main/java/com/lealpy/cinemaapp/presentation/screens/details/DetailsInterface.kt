package com.lealpy.cinemaapp.presentation.screens.details

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.presentation.screens.base.BasePresenterInterface

interface DetailsInterface {

    interface DetailsPresenterInterface : BasePresenterInterface {
        fun onViewCreated(movieId: Int)
    }

    interface DetailsViewInterface {
        fun updateMovie(movie: Movie)
        fun showProgress()
        fun hideProgress()
    }

}
