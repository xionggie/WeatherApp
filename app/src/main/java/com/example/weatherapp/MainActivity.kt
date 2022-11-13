package com.example.weatherapp

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts.RequestPermission
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.models.LatitudeLongitude
import com.example.weatherapp.ui.CurrentConditions
import com.example.weatherapp.ui.CurrentForecastsScreen
import com.example.weatherapp.ui.ForecastScreen
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        setContent{
            val navController = rememberNavController()

            val hasLocationPermission = remember { mutableStateOf(false) }

            val onResult = { value: Boolean ->
                if(ActivityCompat.checkSelfPermission(this@MainActivity, ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    fusedLocationProviderClient
                        .getCurrentLocation(Priority.PRIORITY_BALANCED_POWER_ACCURACY, null)
                        .addOnSuccessListener { location ->
                            val latitudeLongitude = LatitudeLongitude(
                                latitude = location.latitude.toFloat(),
                                longitude = location.longitude.toFloat()
                            )
                        }
                }//Video 01:40:27
            }

            val requestPermissionLauncher = rememberLauncherForActivityResult(
                contract = RequestPermission()) {
                hasLocationPermission.value = it
            }

            NavHost(navController, startDestination = "CurrentConditions"){
                composable("CurrentConditions") {
                    CurrentConditions(
                        hasLocationPermission = hasLocationPermission.value,
                        onGetWeatherForMyLocationClick = {
                            requestPermissionLauncher.launch(ACCESS_COARSE_LOCATION)
                        }
                    ) {
                        navController.navigate("Forecast")
                    }
                }

                composable("Forecast") {
//                    ForecastScreen()
                    CurrentForecastsScreen()
                }
            }
        }
    }

}

