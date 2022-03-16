package com.lealpy.cinemaapp.presentation.screens.details

import com.lealpy.cinemaapp.domain.models.Movie
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem

interface DetailsInterface {

    interface DetailsPresenterInterface {
        fun viewIsReady(movieId: Int)
        fun detachView()
    }

    interface DetailsViewInterface {
        fun updateMovie(movie: Movie)
        fun showProgress()
        fun hideProgress()
    }

}
