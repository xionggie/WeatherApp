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
import com.example.weatherapp.R
import com.example.weatherapp.models.DayForecast
import com.example.weatherapp.models.ForecastTemp
import com.example.weatherapp.toHourMinute
import com.example.weatherapp.toMonthDay

val startDay = 1665017760L
val sunrise = 1664971200L
val sunset = 1665014400L

val forecastData = (0 until 16).map {
    DayForecast(
        date = startDay + (it * (24 * 60 * 60)),
        sunrise = sunrise + (it * 24 * 60 * 60),
        sunset = sunset + (it * 24 * 60 * 60),
        forecastTemp = ForecastTemp(70f + it, 80f + it),
        pressure = 1024f,
        humidity = 76,
    )
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ForecastScreen(){
    Scaffold(
        topBar = { Appbar (stringResource(id = R.string.forecast)) }
    ) {
        LazyColumn {
            items(forecastData) { item: DayForecast ->
                ForecastRow(item = item)
            }
        }
    }
}

@Composable
private fun ForecastRow(item: DayForecast) {
    Row (
        modifier = Modifier.background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
    ){
        val textStyle = TextStyle(
            fontSize = 12.sp,
        )
        Image(painter = painterResource(id = R.drawable.sun_icon), contentDescription = "")
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Text(text = item.date.toMonthDay(),
            style = TextStyle(
                fontSize = 16.sp,
            )
        )
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column {
            Text(text = stringResource(id = R.string.high_temp, item.forecastTemp.max.toInt()),
                style = textStyle,
            )
            Text(text = stringResource(id = R.string.low_temp, item.forecastTemp.min.toInt()),
                style = textStyle,
            )
        }
        Spacer(modifier = Modifier.weight(1f, fill = true))
        Column (
            horizontalAlignment = Alignment.End
        ){
            Text(text = stringResource(id = R.string.sunrise, item.sunrise.toHourMinute()),
                style = textStyle,
            )
            Text(text = stringResource(id = R.string.sunset, item.sunset.toHourMinute()),
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
private fun ForecastRowPreview() {
    ForecastRow(forecastData[0])
}