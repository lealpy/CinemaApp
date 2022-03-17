package com.lealpy.cinemaapp.presentation.screens.movies

import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem

interface MoviesInterface {

    interface MoviesPresenterInterface {
        fun viewCreated()
        fun viewDestroyed()
        fun onGenreItemClicked(genreItem: RecyclerViewItem.GenreItem)
        fun onSwipedRefresh()
    }

    interface MoviesViewInterface {
        fun updateRecyclerViewItems(recyclerViewItems: List<RecyclerViewItem>)
        fun showProgress()
        fun hideProgress()
    }

}
