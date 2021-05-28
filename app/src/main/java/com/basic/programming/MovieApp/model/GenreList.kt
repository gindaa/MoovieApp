package com.basic.programming.MovieApp.model


data class GenreList(
    val GenreList: List<Genre>
)
data class Genre(
    var id:Long,
    var genre : String
)

