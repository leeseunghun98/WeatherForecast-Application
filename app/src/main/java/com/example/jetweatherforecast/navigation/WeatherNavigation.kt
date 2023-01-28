package com.example.jetweatherforecast.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetweatherforecast.model.ParcelableWeatherItem
import com.example.jetweatherforecast.navigation.customtype.WeatherType
import com.example.jetweatherforecast.screens.about.AboutScreen
import com.example.jetweatherforecast.screens.daydetail.ThisWeekDetailScreen
import com.example.jetweatherforecast.screens.favorites.FavoritesScreen
import com.example.jetweatherforecast.screens.main.MainScreen
import com.example.jetweatherforecast.screens.main.MainViewModel
import com.example.jetweatherforecast.screens.search.SearchScreen
import com.example.jetweatherforecast.screens.settings.SettingsScreen
import com.example.jetweatherforecast.screens.splash.WeatherSplashScreen

@Composable
fun WeatherNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = WeatherScreens.SplashScreen.name) {
        composable(WeatherScreens.SplashScreen.name) {
            WeatherSplashScreen(navController = navController)
        }
        val route = WeatherScreens.MainScreen.name
        composable("$route/{city}", arguments = listOf(
            navArgument(name = "city") {
                type = NavType.StringType
            }
        )) {
            it.arguments?.getString("city").let {
                val mainViewModel = hiltViewModel<MainViewModel>()
                MainScreen(navController = navController, mainViewModel, city = it)
            }
        }
        composable(WeatherScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
        composable(WeatherScreens.VersionScreen.name) {
            AboutScreen(navController = navController)
        }
        composable(WeatherScreens.SettingsScreen.name) {
            SettingsScreen(navController = navController)
        }
        composable(WeatherScreens.FavoriteScreen.name) {
            FavoritesScreen(navController = navController)
        }
        val thisWeekDetailScreen = WeatherScreens.ThisWeekDetailScreen.name
        composable("$thisWeekDetailScreen/{weatherItem}/{isImperial}", arguments = listOf(
            navArgument(name = "weatherItem") {
                type = WeatherType()
            }, navArgument(name = "isImperial") {
                type = NavType.BoolType
            }
        )) {
//            val weatherItem = it.arguments?.getParcelable<ParcelableWeatherItem>("weatherItem")
//            ThisWeekDetailScreen(
//                navController = navController,
//                parcelableWeatherItem = weatherItem,,
//            )
            it.arguments?.let { arguments ->
                val parcelableWeatherItem = arguments.getParcelable<ParcelableWeatherItem>("weatherItem")
                val isImperial = arguments.getBoolean("isImperial")
                ThisWeekDetailScreen(navController = navController, parcelableWeatherItem = parcelableWeatherItem!!, isImperial = isImperial)
            }
        }
    }
}