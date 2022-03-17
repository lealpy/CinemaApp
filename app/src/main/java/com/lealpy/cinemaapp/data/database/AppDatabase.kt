package com.lealpy.cinemaapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lealpy.cinemaapp.data.utils.Converters

@Database(
    version = 1,
    entities = [
        MovieEntity::class
    ],
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun moviesDao(): MoviesDao
}
