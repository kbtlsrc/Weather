package com.example.appweather.service

import com.example.appweather.model.All
import com.example.appweather.model.AllList
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather?&units=metric&APPID=ffef07189954b77561d4467167f1eed9")
    fun getWeather(
        @Query("q") cityName: String
    ): Call<AllList>



}