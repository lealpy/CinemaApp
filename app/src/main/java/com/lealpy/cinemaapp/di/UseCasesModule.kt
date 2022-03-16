package com.lealpy.cinemaapp.di

import com.lealpy.cinemaapp.data.repositories.MoviesRepositoryImpl
import com.lealpy.cinemaapp.domain.usecases.GetAllMoviesUseCase
import com.lealpy.cinemaapp.domain.usecases.GetMovieByIdUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    fun provideGetAllMoviesUseCase(
        moviesRepository: MoviesRepositoryImpl,
    ): GetAllMoviesUseCase {
        return GetAllMoviesUseCase(moviesRepository = moviesRepository)
    }

    @Provides
    fun provideGetMovieByIdUseCase(
        moviesRepository: MoviesRepositoryImpl,
    ): GetMovieByIdUseCase {
        return GetMovieByIdUseCase(moviesRepository = moviesRepository)
    }

}