package com.lealpy.cinemaapp.presentation.screens.main.presenter

import com.lealpy.cinemaapp.presentation.screens.main.MainInterface
import com.lealpy.cinemaapp.presentation.utils.CheckNetworkConnection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class MainPresenter @Inject constructor(
    private val view: MainInterface.MainViewInterface,
    private val checkNetworkConnection: CheckNetworkConnection,
) : MainInterface.MainPresenterInterface, CoroutineScope {

    private var job = Job()

    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    override fun onViewDestroyed() {
        job.cancel()
    }

    override fun onViewCreated() {
        launch {
            checkNetworkConnection.networkStatus.collect { networkStatus ->
                when (networkStatus) {
                    true -> view.hideMessageNoInternet()
                    false -> view.showMessageNoInternet()
                }
            }
        }
    }

}
