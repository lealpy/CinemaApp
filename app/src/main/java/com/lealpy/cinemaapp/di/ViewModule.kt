package com.lealpy.cinemaapp.di

import androidx.fragment.app.Fragment
import com.lealpy.cinemaapp.presentation.screens.movies.MoviesInterface
import com.lealpy.cinemaapp.presentation.screens.movies.presenter.MoviesPresenter
import com.lealpy.cinemaapp.presentation.screens.movies.view.MoviesFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class ViewBindsModule {
    @Binds
    abstract fun bindMoviesFragment(
        moviesFragment: MoviesFragment,
    ): MoviesInterface.MoviesViewInterface

    @Binds
    abstract fun bindPresenter(
        moviesPresenter: MoviesPresenter,
    ): MoviesInterface.MoviesPresenterInterface
}

@InstallIn(FragmentComponent::class)
@Module
class ViewProvidesModule {

    @Provides
    fun provideMoviesFragment(fragment: Fragment): MoviesFragment {
        return fragment as MoviesFragment
    }

}
