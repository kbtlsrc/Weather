package com.example.appweather.service

import com.example.appweather.model.AllData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("weather?appid=ffef07189954b77561d4467167f1eed9")
    fun getWeather(@Query("q") cityName: String): Call<AllData>



}