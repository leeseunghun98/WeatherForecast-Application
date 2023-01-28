package com.example.jetweatherforecast.screens.daydetail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.jetweatherforecast.R
import com.example.jetweatherforecast.model.FeelsLike
import com.example.jetweatherforecast.model.ParcelableWeatherItem
import com.example.jetweatherforecast.model.Temp
import com.example.jetweatherforecast.model.WeatherObject
import com.example.jetweatherforecast.utils.WeatherItemConverter
import com.example.jetweatherforecast.utils.parcelWeatherConverter
import com.example.jetweatherforecast.widgets.*

@Composable
fun ThisWeekDetailScreen(
    navController: NavController = NavController(context = LocalContext.current),
    parcelableWeatherItem: ParcelableWeatherItem,
    isImperial: Boolean = false
) {
    Box {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.background_image),
            contentDescription = "background_image",
            contentScale = ContentScale.FillBounds
        )
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(4.dp)) {
            ThisWeekDetailScreenScaffold(
                parcelableWeatherItem = parcelableWeatherItem,
                navController = navController,
                isImperial = isImperial
            )
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ThisWeekDetailScreenScaffold(
    parcelableWeatherItem: ParcelableWeatherItem,
    navController: NavController,
    isImperial: Boolean
) {
    Scaffold(backgroundColor = Color.Transparent,
        topBar = {
        WeatherAppBar(
            navController = navController,
            title = "Weather Details",
            icon = Icons.Default.ArrowBack,
            isMainScreen = false,
        ) {
            navController.popBackStack()
        }
    }) {
        ThisWeekDetailScreenContent(data = parcelableWeatherItem, isImperial = isImperial)
    }
}

@Composable
fun ThisWeekDetailScreenContent(data: ParcelableWeatherItem, isImperial: Boolean) {
    val imageUrl = "https://openweathermap.org/img/wn/${data.weather[0].icon}.png"
    WeatherDetail(weatherItem = WeatherItemConverter(data), imageUrl = imageUrl, isImperial = isImperial)
}
