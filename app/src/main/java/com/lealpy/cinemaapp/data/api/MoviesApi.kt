package com.lealpy.cinemaapp.data.api

import com.lealpy.cinemaapp.data.models.ApiResponse
import retrofit2.http.GET

interface MoviesApi {

    @GET("sequeniatesttask/films.json")
    suspend fun getAllMovies(): ApiResponse

}
