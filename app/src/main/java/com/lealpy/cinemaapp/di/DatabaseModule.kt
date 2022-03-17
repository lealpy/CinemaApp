package com.lealpy.cinemaapp.di

import android.content.Context
import androidx.room.Room
import com.lealpy.cinemaapp.data.database.AppDatabase
import com.lealpy.cinemaapp.data.database.MoviesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            ROOM_DATABASE_FILE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCharactersDao(appDatabase: AppDatabase): MoviesDao {
        return appDatabase.moviesDao()
    }

    companion object {
        private const val ROOM_DATABASE_FILE_NAME = "database.db"
    }

}
