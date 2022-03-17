package com.lealpy.cinemaapp.presentation.screens.movies

import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem
import com.lealpy.cinemaapp.presentation.screens.base.BasePresenterInterface

interface MoviesInterface {

    interface MoviesPresenterInterface : BasePresenterInterface {
        fun onViewCreated()
        fun onGenreItemClicked(genreItem: RecyclerViewItem.GenreItem)
        fun onChapterItemClicked(chapterItem: RecyclerViewItem.ChapterItem)
        fun onSwipedRefresh()
    }

    interface MoviesViewInterface {
        fun updateRecyclerViewItems(recyclerViewItems: List<RecyclerViewItem>)
        fun showProgress()
        fun hideProgress()
    }

}
