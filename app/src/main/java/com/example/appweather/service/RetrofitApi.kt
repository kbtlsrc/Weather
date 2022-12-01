package com.example.appweather.service

import com.example.appweather.model.All
import com.example.appweather.model.AllList
import com.example.appweather.model.WeatherList
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    private val BASE_URL = "https://api.openweathermap.org/"

    val retrofit : ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    fun getDataService(cityName: String): Call<AllList> {
        return retrofit.getWeather(cityName)
    }



}