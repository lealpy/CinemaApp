package com.lealpy.cinemaapp.presentation.screens.base

import kotlinx.coroutines.CoroutineScope

interface BasePresenterInterface : CoroutineScope {
    fun onViewDestroyed()
}
