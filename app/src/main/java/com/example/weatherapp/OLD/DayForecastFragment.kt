package com.example.weatherapp.OLD

//import android.os.Bundle
//import android.view.View
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.navArgs
//import com.example.weatherapp.databinding.FragmentDayforecastBinding
//import java.time.LocalDateTime
//import java.time.LocalTime
//import java.time.ZoneOffset
//import java.time.format.DateTimeFormatter
//
//class DayForecastFragment : Fragment(R.layout.fragment_dayforecast) {
//
//    private lateinit var binding: FragmentDayforecastBinding
////    private val args: DayForecastFragmentArgs by navArgs()
//
//    private val dateFormatter = DateTimeFormatter.ofPattern("MMM dd")
//    private val timeFormatter = DateTimeFormatter.ofPattern("h:mm")
//
//    /**List of 16 Dates 09/26 - 10/11
//     *  1   09/26/2022
//     *  2   09/27/2022
//     *  3   09/28/2022
//     *  4   09/29/2022
//     *  5   09/30/2022
//     *  6   10/01/2022
//     *  7   10/02/2022
//     *  8   10/03/2022
//     *  9   10/04/2022
//     *  10  10/05/2022
//     *  11  10/06/2022
//     *  12  10/07/2022
//     *  13  10/08/2022
//     *  14  10/09/2022
//     *  15  10/10/2022
//     *  16  10/11/2022
//     */
//    private  val dayForecastData: List<DayForecast> = listOf(
//    DayForecast(getCurrentDateMMMdd(1664377633L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(65F, 80F)),
//    DayForecast(getCurrentDateMMMdd(1664464033L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(60F, 75F)),
//    DayForecast(getCurrentDateMMMdd(1664550433L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(66F, 70F)),
//    DayForecast(getCurrentDateMMMdd(1664636833L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(63F, 75F)),
//    DayForecast(getCurrentDateMMMdd(1664723233L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(62F, 85F)),
//    DayForecast(getCurrentDateMMMdd(1664809633L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(65F, 83F)),
//    DayForecast(getCurrentDateMMMdd(1664896033L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(67F, 72F)),
//    DayForecast(getCurrentDateMMMdd(1664982433L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(66F, 76F)),
//    DayForecast(getCurrentDateMMMdd(1665068833L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(68F, 82F)),
//    DayForecast(getCurrentDateMMMdd(1665155233L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(61F, 71F)),
//    DayForecast(getCurrentDateMMMdd(1665241633L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(62F, 74F)),
//    DayForecast(getCurrentDateMMMdd(1665328033L).toString(), getTime(8).toString(), getTime(9).toString(),  "1023", "100"
//        , createNewForecastTemp(64F, 76F)),
//    DayForecast(getCurrentDateMMMdd(1665414433L).toString(), getTime(8).toString(), getTime(9).toString(), "1023", "100"
//        , createNewForecastTemp(63F, 77F)),
//    DayForecast(getCurrentDateMMMdd(1665500833L).toString(), getTime(8).toString(), getTime(9).toString(), "1023", "100"
//        , createNewForecastTemp(68F, 80F))
//    )
//
//    //function onViewCreated
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentDayforecastBinding.bind(view)
//        binding.dayForecastList.adapter = DayForecastAdapter(dayForecastData)
//
//        (activity as AppCompatActivity).supportActionBar?.title = "Day Forecast"
//
//    }
//
//    private fun getCurrentDateMMMdd(dateTimeStamp:Long): String {
//        val dateTime = LocalDateTime.ofEpochSecond(dateTimeStamp, 0, ZoneOffset.of("-5"))
//        return dateFormatter.format(dateTime)
//    }
//
//    private fun createNewForecastTemp(minTemp: Float, maxTemp: Float): ForecastTemp {
//        return ForecastTemp(minTemp, maxTemp)
//    }
//
//    private fun getTime(time:Int): String {
//        return timeFormatter.format(LocalTime.of(time, 0, 0))
//    }
//
//}