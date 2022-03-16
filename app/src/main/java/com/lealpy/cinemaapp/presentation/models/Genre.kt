package com.lealpy.cinemaapp.presentation.models

enum class Genre(val id: Int, val genreName: String) {
    DRAMA(-10, "драма"),
    FANTASY(-11, "фэнтези"),
    CRIMINAL(-12, "криминал"),
    DETECTIVE(-13, "детектив"),
    MELODRAMA(-14, "мелодрама"),
    BIOGRAPHY(-15, "биография"),
    COMEDY(-16, "комедия"),
    FICTION(-17, "фантастика"),
    ACTION(-18, "боевик"),
    THRILLER(-19, "триллер"),
    MUSICAL(-20, "мюзикл"),
    ADVENTURES(-21, "приключения"),
    HORROR(-22, "ужасы"),
}
