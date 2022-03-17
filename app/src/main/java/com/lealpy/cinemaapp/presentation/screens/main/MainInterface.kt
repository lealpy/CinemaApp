package com.lealpy.cinemaapp.presentation.screens.main

interface MainInterface {

    interface MainPresenterInterface {
        fun viewCreated()
        fun viewDestroyed()
    }

    interface MainViewInterface {
        fun showMessageNoInternet()
        fun hideMessageNoInternet()
    }

}
