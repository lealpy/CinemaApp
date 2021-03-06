package com.lealpy.cinemaapp.presentation.screens.details.presenter

import com.lealpy.cinemaapp.domain.usecases.GetMovieByIdUseCase
import com.lealpy.cinemaapp.presentation.screens.details.DetailsInterface
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class DetailsPresenter @Inject constructor(
    private val view: DetailsInterface.DetailsViewInterface,
    private val getMovieByIdUseCase: GetMovieByIdUseCase,
) : DetailsInterface.DetailsPresenterInterface {

    private var job = SupervisorJob()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onViewDestroyed() {
        job.cancelChildren()
    }

    override fun onViewCreated(movieId: Int) {
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
