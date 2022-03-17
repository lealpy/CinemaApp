package com.lealpy.cinemaapp.presentation.models

enum class Genre(val id: Int, val genreName: String) {
    ALL_GENRES(-10, "все жанры"),
    DRAMA(-11, "драма"),
    FANTASY(-12, "фэнтези"),
    CRIMINAL(-13, "криминал"),
    DETECTIVE(-14, "детектив"),
    MELODRAMA(-15, "мелодрама"),
    BIOGRAPHY(-16, "биография"),
    COMEDY(-17, "комедия"),
    FICTION(-18, "фантастика"),
    ACTION(-19, "боевик"),
    THRILLER(-20, "триллер"),
    MUSICAL(-21, "мюзикл"),
    ADVENTURES(-22, "приключения"),
    HORROR(-23, "ужасы"),
}
