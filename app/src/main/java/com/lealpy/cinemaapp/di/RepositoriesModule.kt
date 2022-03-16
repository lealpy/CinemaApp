package com.lealpy.cinemaapp.di

import com.lealpy.cinemaapp.data.api.MoviesApi
import com.lealpy.cinemaapp.data.database.MoviesDao
import com.lealpy.cinemaapp.data.repositories.MoviesRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoriesModule {

    @Provides
    @Singleton
    fun provideCharactersRepository(
        moviesApi: MoviesApi,
        moviesDao: MoviesDao,
    ): MoviesRepositoryImpl {
        return MoviesRepositoryImpl(
            moviesApi = moviesApi,
            moviesDao = moviesDao,
        )
    }

}
