package com.lealpy.cinemaapp.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {

    @Query("SELECT * FROM movie_entities WHERE id = :movieId")
    suspend fun getMovieEntityById(movieId: Int): MovieEntity

    @Query("SELECT * FROM movie_entities")
    suspend fun getAllMovieEntities(): List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovieEntities(movieEntities: List<MovieEntity>)

}
