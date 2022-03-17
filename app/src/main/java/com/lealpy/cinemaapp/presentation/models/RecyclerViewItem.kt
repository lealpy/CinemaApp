package com.lealpy.cinemaapp.presentation.models

sealed class RecyclerViewItem(val itemId: Int) {

    data class ChapterItem(
        val id: Int,
        val chapter: Chapter,
        val dropDownVisibility: Int,
    ) : RecyclerViewItem(itemId = id)

    data class GenreItem(
        val id: Int,
        val genre: Genre,
        val isChecked: Boolean,
    ) : RecyclerViewItem(itemId = id)

    data class MovieItem(
        val id: Int,
        val localizedName: String?,
        val name: String?,
        val year: Int?,
        val rating: Double?,
        val imageUrl: String?,
        val description: String?,
        val genres: List<String>?,
    ) : RecyclerViewItem(itemId = id)

}
