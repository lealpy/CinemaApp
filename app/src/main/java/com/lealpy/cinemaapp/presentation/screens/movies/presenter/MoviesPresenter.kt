package com.lealpy.cinemaapp.presentation.screens.movies.presenter

import com.lealpy.cinemaapp.domain.usecases.GetAllMoviesUseCase
import com.lealpy.cinemaapp.domain.usecases.GetMoviesByGenreUseCase
import com.lealpy.cinemaapp.presentation.models.Chapter
import com.lealpy.cinemaapp.presentation.models.Genre
import com.lealpy.cinemaapp.presentation.models.Genre.ALL_GENRES
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem
import com.lealpy.cinemaapp.presentation.screens.movies.MoviesInterface
import com.lealpy.cinemaapp.presentation.utils.toGenreItems
import com.lealpy.cinemaapp.presentation.utils.toMovieItems
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MoviesPresenter @Inject constructor(
    private val view: MoviesInterface.MoviesViewInterface,
    private val getAllMoviesUseCase: GetAllMoviesUseCase,
    private val getMoviesByGenreUseCase: GetMoviesByGenreUseCase,
) : MoviesInterface.MoviesPresenterInterface, CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private var checkedGenre = ALL_GENRES
    private var isGenresOpened = true

    override fun viewDestroyed() {
        job.cancel()
    }

    override fun viewCreated() {
        updateItems()
    }

    override fun onSwipedRefresh() {
        updateItems()
    }

    override fun onGenreItemClicked(genreItem: RecyclerViewItem.GenreItem) {
        checkedGenre = genreItem.genre
        updateItems()
    }

    override fun onChapterItemClicked(chapterItem: RecyclerViewItem.ChapterItem) {
        if (chapterItem.chapter == Chapter.GENRES) {
            isGenresOpened = !isGenresOpened
            updateItems()
        }
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

        val genreItems = if (isGenresOpened) {
            enumValues<Genre>().toList().toGenreItems(checkedGenre)
        } else {
            emptyList()
        }

        val movieItems = when (checkedGenre) {
            ALL_GENRES -> {
                getAllMoviesUseCase().toMovieItems()
            }
            else -> {
                getMoviesByGenreUseCase(checkedGenre.genreName).toMovieItems()
            }
        }

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
