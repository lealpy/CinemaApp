package com.lealpy.cinemaapp.di

import android.app.Activity
import com.lealpy.cinemaapp.presentation.screens.main.view.MainActivity
import com.lealpy.cinemaapp.presentation.screens.main.MainInterface
import com.lealpy.cinemaapp.presentation.screens.main.presenter.MainPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@InstallIn(ActivityComponent::class)
@Module
abstract class ScreenMainBindsModule {
    @Binds
    abstract fun bindMainFragment(
        mainActivity: MainActivity,
    ): MainInterface.MainViewInterface

    @Binds
    abstract fun bindMainPresenter(
        mainPresenter: MainPresenter,
    ): MainInterface.MainPresenterInterface
}

@InstallIn(ActivityComponent::class)
@Module
class ScreenMainProvidesModule {

    @Provides
    fun provideMainActivity(activity: Activity): MainActivity {
        return activity as MainActivity
    }

}
