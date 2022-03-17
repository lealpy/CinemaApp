package com.lealpy.cinemaapp.di

import androidx.fragment.app.Fragment
import com.lealpy.cinemaapp.presentation.screens.details.DetailsInterface
import com.lealpy.cinemaapp.presentation.screens.details.presenter.DetailsPresenter
import com.lealpy.cinemaapp.presentation.screens.details.view.DetailsFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class ScreenDetailsBindsModule {
    @Binds
    abstract fun bindDetailsFragment(
        detailsFragment: DetailsFragment,
    ): DetailsInterface.DetailsViewInterface

    @Binds
    abstract fun bindDetailsPresenter(
        detailsPresenter: DetailsPresenter,
    ): DetailsInterface.DetailsPresenterInterface
}

@InstallIn(FragmentComponent::class)
@Module
class ScreenDetailsProvidesModule {

    @Provides
    fun provideDetailsFragment(fragment: Fragment): DetailsFragment {
        return fragment as DetailsFragment
    }

}