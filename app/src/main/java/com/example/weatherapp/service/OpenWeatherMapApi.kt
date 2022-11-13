package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.CurrentForecasts
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentCondition(
        @Query("zip") zip : String,
        @Query("appid") apiKey : String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("units") units : String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey : String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("units") units : String = "imperial"
    )


    @GET("data/2.5/weather")
    suspend fun getCurrentForecast(
        @Query("zip") zip : String,
        @Query("appid") apiKey : String = "61e80a81c053d9a475382b912d5f20d9",
        @Query("cnt") cnt: Int = 16,
        @Query("units") units : String = "imperial"
    ) : CurrentForecasts                   //: CurrentForecast

}

