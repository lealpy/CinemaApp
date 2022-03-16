package com.lealpy.cinemaapp.presentation.screens.movies

import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem

interface MoviesInterface {

    interface MoviesModelInterface {
        suspend fun getRecyclerViewItems(): List<RecyclerViewItem>
    }

    interface MoviesPresenterInterface {
        fun viewIsReady()
        fun detachView()
        fun onGenreItemClicked(genreItem: RecyclerViewItem.GenreItem)
        fun onSwipedRefresh()
    }

    interface MoviesViewInterface {
        fun updateRecyclerViewItems(recyclerViewItems: List<RecyclerViewItem>)
        fun showProgress()
        fun hideProgress()
    }

}
