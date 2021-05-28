package com.basic.programming.MovieApp.Services

import com.basic.programming.MovieApp.model.GenreList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreServices {

    @GET ("/3/genre/movie/list")
    fun getGenre(@Query("api_key") key: String): Call<GenreList>
}