package com.lealpy.cinemaapp.domain.models

data class Movie(
    val id: Int,
    val localizedName: String,
    val name: String,
    val year: Int,
    val rating: Double,
    val imageUrl: String,
    val description: String,
)
