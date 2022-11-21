package com.example.myapplication55.data

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("posts")
    fun getData(): Call<List<DataItem>>
}