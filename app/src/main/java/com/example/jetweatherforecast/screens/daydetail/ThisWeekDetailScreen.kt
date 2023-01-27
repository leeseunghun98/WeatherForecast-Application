package com.example.jetweatherforecast.screens.daydetail

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.jetweatherforecast.data.DataOrException
import com.example.jetweatherforecast.model.ParcelableWeatherItem
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.navigation.WeatherScreens
import com.example.jetweatherforecast.screens.main.MainScaffold
import com.example.jetweatherforecast.utils.WeatherItemConverter
import com.example.jetweatherforecast.utils.formatDate
import com.example.jetweatherforecast.utils.formatDecimals
import com.example.jetweatherforecast.widgets.*

@Preview
@Composable
fun ThisWeekDetailScreen(
    navController: NavController? = null,
    parcelableWeatherItem: ParcelableWeatherItem? = null
) {
    Surface(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)) {
        ThisWeekDetailScreenScaffold(
            navController = navController!!,
            parcelableWeatherItem = parcelableWeatherItem
        )
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ThisWeekDetailScreenScaffold(
    parcelableWeatherItem: ParcelableWeatherItem? = null,
    navController: NavController
) {
    Scaffold(topBar = {
        WeatherAppBar(
            navController = navController,
            title = "Weather Details",
            icon = Icons.Default.ArrowBack,
            isMainScreen = false
        ) {
            navController.popBackStack()
        }
    }) {
        ThisWeekDetailScreenContent(data = parcelableWeatherItem!!)
    }
}

@Composable
fun ThisWeekDetailScreenContent(data: ParcelableWeatherItem) {
    val imageUrl = "https://openweathermap.org/img/wn/${data.weather[0].icon}.png"
    Column(
        Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = formatDate(data.dt),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(6.dp)
        )
        Surface(
            modifier = Modifier
                .padding(4.dp)
                .size(200.dp), shape = CircleShape, color = Color(0xFFFFC400)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                WeatherStateImage(imageUrl = imageUrl)
                Text(
                    text = formatDecimals(data.temp.day) + "°",
                    style = MaterialTheme.typography.h4,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(text = "avg", fontWeight = FontWeight.Light, fontSize = 10.sp)
                Text(text = data.weather[0].main, fontStyle = FontStyle.Italic)
            }
        }
//        HumidityWindPressureRow(weather = data, isImperial = isImperial)
        Divider()
        SunSetSunRiseRow(weather = WeatherItemConverter(data))
    }
}
