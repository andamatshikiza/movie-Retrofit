package com.example.moviecat.Repo

import com.example.moviecat.Data.DataClassItem
import retrofit2.Call
import retrofit2.http.GET

interface url_apiInterface {

    @GET("posts")
    fun getData():Call<List<DataClassItem>>
}