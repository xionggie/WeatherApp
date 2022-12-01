package com.example.weatherapp.service

import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.CurrentForecasts
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApi {

    @GET("data/2.5/weather")
    suspend fun getCurrentCondition(
        @Query("zip") zip : String,
        @Query("appid") apiKey : String = "d2331cffb7676c350c207535e606f7ea",
        @Query("units") units : String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/weather")
    suspend fun getCurrentConditions(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("appid") apiKey : String = "d2331cffb7676c350c207535e606f7ea",
        @Query("units") units : String = "imperial"
    ) : CurrentConditions

    @GET("data/2.5/forecast/daily")
    suspend fun getCurrentForecast(
        @Query("zip") zip : String,
        @Query("appid") apiKey : String = "d2331cffb7676c350c207535e606f7ea",
        @Query("cnt") cnt: Int = 16,
        @Query("units") units : String = "imperial"
    ) : CurrentForecasts

    @GET("data/2.5/forecast/daily")
    suspend fun getCurrentForecasts(
        @Query("lat") latitude: Float,
        @Query("lon") longitude: Float,
        @Query("cnt") cnt: Int = 16,
        @Query("appid") apiKey : String = "d2331cffb7676c350c207535e606f7ea",
        @Query("units") units : String = "imperial"
    ) : CurrentForecasts

}

