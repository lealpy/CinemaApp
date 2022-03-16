package com.lealpy.cinemaapp.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_entities")
data class MovieEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "localized_name") val localizedName: String?,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "year") val year: Int?,
    @ColumnInfo(name = "rating") val rating: Double?,
    @ColumnInfo(name = "image_url") val imageUrl: String?,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "genres") val genres: List<String>?,
)
