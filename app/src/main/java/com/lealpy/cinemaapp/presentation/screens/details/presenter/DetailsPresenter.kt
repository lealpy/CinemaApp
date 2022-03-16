package com.lealpy.cinemaapp.presentation.screens.details.presenter

import com.lealpy.cinemaapp.domain.usecases.GetMovieByIdUseCase
import com.lealpy.cinemaapp.presentation.screens.details.DetailsInterface
import com.lealpy.cinemaapp.presentation.screens.movies.MoviesInterface
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailsPresenter @Inject constructor(
    private val view: DetailsInterface.DetailsViewInterface,
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
) : DetailsInterface.DetailsPresenterInterface, CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun detachView() {
        job.cancel()
    }

    override fun viewIsReady(movieId: Int) {
        updateItem(movieId)
    }

    private fun updateItem(movieId: Int) {
        launch {
            view.showProgress()

            val movie = withContext(Dispatchers.IO) {
                getMovieByIdUseCase(movieId = movieId)
            }

            view.updateMovie(movie)

            view.hideProgress()
        }
    }

}