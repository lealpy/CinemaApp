package com.lealpy.cinemaapp.di

import android.content.Context
import com.lealpy.cinemaapp.presentation.utils.CheckNetworkConnection
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideCheckNetworkConnection(@ApplicationContext appContext: Context): CheckNetworkConnection {
        return CheckNetworkConnection(appContext)
    }

}
