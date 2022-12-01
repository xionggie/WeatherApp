package com.example.weatherapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.R
import com.example.weatherapp.models.*
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay

const val currentStartDay = 1668313474L
const val currentSunrise = 1664971200L
const val currentSunset = 1665014400L

private val currentForecastsList = mutableListOf<CurrentForecastsData>()

val currentForecastData = (0 until 16).map {
    currentForecastsList.add( CurrentForecastsData(
        date = currentStartDay + (it * (24 * 60 * 60)),
        sunrise = currentSunrise + (it * (24 * 60 * 60)),
        sunset = currentSunset + (it * (24 * 60 * 60)),
        forecastTemp = CurrentForecastTemp(70f + it, 80f + it),
        pressure = 1024f,
        humidity = 76,
    ))
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CurrentForecastsScreen(
    viewModel: CurrentForecastViewModel = hiltViewModel(),
){
    Scaffold(
        topBar = { Appbar (stringResource(id = R.string.forecast)) }
    ) {
        LazyColumn (
            modifier = Modifier.fillMaxSize().background(Color.White)
            ) {
            items(
                items = currentForecastsList,
              ) { currentForecasts ->
                CurrentForecastRow( currentForecasts = currentForecasts)
            }
        }
    }
}

@Composable
private fun CurrentForecastRow(currentForecasts: CurrentForecastsData) {
    Row (
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )
        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Text(
            text = currentForecasts.date.toMonthDay(),
            style = TextStyle(fontSize = 16.sp,)
        )

        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(text = stringResource(id = R.string.high_temp, currentForecasts.forecastTemp.maxTemperature.toInt()),
                style = textStyle,
            )
            Text(text = stringResource(id = R.string.low_temp, currentForecasts.forecastTemp.minTemperature.toInt()),
                style = textStyle,
            )
        }

        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column (
            horizontalAlignment = Alignment.End
        ){
            Text(text = stringResource(id = R.string.sunrise, currentForecasts.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(text = stringResource(id = R.string.sunset, currentForecasts.sunset.toHourMinute()),
                style = textStyle,
            )
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 5.dp))
}

@Preview(
    showSystemUi = true
)

@Composable
fun CurrentForecastsPreview() {

}