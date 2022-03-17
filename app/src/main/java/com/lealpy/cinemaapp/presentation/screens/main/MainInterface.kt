package com.lealpy.cinemaapp.presentation.screens.main

import com.lealpy.cinemaapp.presentation.screens.base.BasePresenterInterface

interface MainInterface {

    interface MainPresenterInterface : BasePresenterInterface {
        fun onViewCreated()
    }

    interface MainViewInterface {
        fun showMessageNoInternet()
        fun hideMessageNoInternet()
    }

}
