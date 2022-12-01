package com.example.weatherapp.ui

import androidx.lifecycle.ViewModel
import com.example.weatherapp.models.CurrentConditions
import com.example.weatherapp.models.LatitudeLongitude
import com.example.weatherapp.service.OpenWeatherMapApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class CurrentConditionsViewModel @Inject constructor(private val api: OpenWeatherMapApi): ViewModel() {

    private val _currentConditions = Channel<CurrentConditions>()
    public val currentConditions: Flow<CurrentConditions> = _currentConditions.receiveAsFlow()

    fun fetchData() = runBlocking {
        val currentConditions = api.getCurrentCondition("55423")
        _currentConditions.trySend(currentConditions)
    }

    fun fetchCurrentLocationData(latitudeLongitude: LatitudeLongitude) = runBlocking {
        val currentConditions = api.getCurrentConditions(latitudeLongitude.latitude, latitudeLongitude.longitude)
        _currentConditions.trySend(currentConditions)
    }
}