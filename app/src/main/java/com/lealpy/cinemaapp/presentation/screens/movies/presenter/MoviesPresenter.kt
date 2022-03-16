package com.lealpy.cinemaapp.presentation.screens.movies.presenter

import com.lealpy.cinemaapp.domain.usecases.GetAllMoviesUseCase
import com.lealpy.cinemaapp.presentation.models.Genre
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem
import com.lealpy.cinemaapp.presentation.models.Chapter
import com.lealpy.cinemaapp.presentation.screens.movies.MoviesInterface
import com.lealpy.cinemaapp.presentation.utils.toMovieItems
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MoviesPresenter @Inject constructor(
    private val view: MoviesInterface.MoviesViewInterface,
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
) : MoviesInterface.MoviesPresenterInterface, CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun detachView() {
        job.cancel()
    }

    override fun viewIsReady() {
        updateItems()
    }

    override fun onSwipedRefresh() {
        updateItems()
    }

    override fun onGenreItemClicked(genreItem: RecyclerViewItem.GenreItem) {
        genreItem.genre
    }

    private fun updateItems() {
        launch {
            view.showProgress()

            val movies = withContext(Dispatchers.IO) {
                getRecyclerViewItems()
            }

            view.updateRecyclerViewItems(movies)

            view.hideProgress()
        }
    }

    private suspend fun getRecyclerViewItems(): List<RecyclerViewItem> {
        val recyclerViewItems = mutableListOf<RecyclerViewItem>()

        val genreItems = mutableListOf<RecyclerViewItem.GenreItem>()
        enumValues<Genre>().forEach { genre ->
            genreItems.add(
                RecyclerViewItem.GenreItem(
                    id = genre.id,
                    genre = genre
                )
            )
        }

        val movieItems = getAllMoviesUseCase().toMovieItems()

        recyclerViewItems.add(
            RecyclerViewItem.ChapterItem(
                id = Chapter.GENRES.id,
                chapter = Chapter.GENRES
            )
        )

        recyclerViewItems.addAll(genreItems)

        recyclerViewItems.add(
            RecyclerViewItem.ChapterItem(
                id = Chapter.MOVIES.id,
                chapter = Chapter.MOVIES
            )
        )

        recyclerViewItems.addAll(movieItems)

        return recyclerViewItems
    }

}
