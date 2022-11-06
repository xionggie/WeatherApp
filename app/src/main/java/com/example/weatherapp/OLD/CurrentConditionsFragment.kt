package com.example.weatherapp.OLD

//
//import android.os.Bundle
//import android.view.View
//import androidx.fragment.app.Fragment
//import androidx.navigation.fragment.findNavController
//import com.example.weatherapp.databinding.FragmentCurrentConditionsBinding
//
//class CurrentConditionsFragment : Fragment(R.layout.fragment_current_conditions) {
//
//    private lateinit var binding: FragmentCurrentConditionsBinding
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        binding = FragmentCurrentConditionsBinding.bind(view)
//        binding.forecastButton.setOnClickListener{
//            val dayForecast = DayForecast("Jan 31",
//                sunrise = "8:00AM",
//                sunset = "9:00PM",
//                pressure = "1023",
//                humidity = "100",
//                temp = ForecastTemp(80F, 65F) )
//            val actionDayForecast = CurrentConditionsFragmentDirections.actionCurrentConditionsFragmentToDayForecastFragment(dayForecast)
//            findNavController().navigate(actionDayForecast)
//
//        }
//    }
//
//}