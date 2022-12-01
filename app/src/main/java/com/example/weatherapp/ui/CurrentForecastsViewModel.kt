package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.*
import com.example.weatherapp.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CurrentForecastViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {

    private val _currentForecast = Channel<CurrentForecasts>()
    public val currentForecast: Flow<CurrentForecasts> = _currentForecast.receiveAsFlow()

    fun fetchData() = runBlocking {
        val currentForecast = api.getCurrentForecast("55423")
        _currentForecast.trySend(currentForecast)
    }

    fun fetchForecastLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val currentForecasts = api.getCurrentForecasts(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _currentForecast.trySend(currentForecasts)
    }

}