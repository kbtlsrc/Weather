package com.example.appweather.model

import com.google.gson.annotations.SerializedName

data class All(
    val all: Int,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lon")
    val lon: Double,
    val feels_like: Double,
    @SerializedName("humidity")
    val humidity: Int,
    val pressure: Int,
    @SerializedName("temp")
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double,
    @SerializedName("country")
    val country: String,
    val id: Int,
    val sunrise: Int,
    val sunset: Int,
    val type: Int,

    val description: String,
    @SerializedName("icon")
    val icon: String,
    val main: String,
    val base: String,
    val clouds: Clouds,
    val cod: Int,
    val coord: Coord,
    val dt: Int,
    val idWeather: Int,
    val main1: Main,
    @SerializedName("name")
    val name: String,
    val sys: Sys,
    val timezone: Int,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind,
    val deg: Int,
    @SerializedName("speed")
    val speedWind: Int
)  {
}