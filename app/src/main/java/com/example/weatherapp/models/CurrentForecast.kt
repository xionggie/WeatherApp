package com.example.weatherapp.models

import com.squareup.moshi.Json

data class ForecastWeatherData(
    @Json(name = "icon") val iconName: String,
)

data class CurrentForecastsData(
    @Json(name = "dt") val date: Long,
    @Json(name = "sunrise") val sunrise: Long,
    @Json(name = "sunset") val sunset: Long,
    @Json(name = "temp") val forecastTemp: CurrentForecastTemp,
    @Json(name = "pressure") val pressure: Float,
    @Json(name = "humidity") val humidity: Int,
)

data class CurrentForecastTemp(
    @Json(name = "min") val minTemperature: Float,
    @Json(name = "max") val maxTemperature: Float,
)

data class CurrentForecasts(
    @Json(name ="weather") val forecastData: List<CurrentForecastsData>,
//    @Json(name ="temp") val forecasts: CurrentForecastTemp,
)