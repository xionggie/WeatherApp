package com.example.weatherapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DayForecastAdapter(private val data: List<DayForecast>) : RecyclerView.Adapter<DayForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_forecast_item, parent, false)
        return DayForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: DayForecastViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}

class DayForecastViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private var image: ImageView
    private var date: TextView
    private var tempHigh: TextView
    private var tempLow: TextView
    private var sunrise: TextView
    private var sunset: TextView
    private val forecastTemp: TextView

    init{
        image = view.findViewById(R.id.current_forecast_icon)
        date = view.findViewById(R.id.forecast_date)
        tempHigh = view.findViewById(R.id.forecast_tempHigh)
        tempLow = view.findViewById(R.id.forecast_tempLow)
        sunrise = view.findViewById(R.id.forecast_sunrise)
        sunset = view.findViewById(R.id.forecast_sunset)
        forecastTemp = view.findViewById(R.id.forecast_temp)
    }

    fun bind(data: DayForecast) {
        date.text = data.date.toString()
        tempHigh.text = "High: "+data.temp.max.toString()+"°"
        tempLow.text ="Low: "+data.temp.min.toString()+"°"
        sunrise.text = "Sunrise: "+data.sunrise.toString()+"am"
        sunset.text = "Sunset: "+data.sunset.toString()+"pm"
//        forecastTemp.text = data.temp.toString()
    }


}