package com.example.jetweatherforecast.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

//@Suppress("DEPRECATED_ANNOTATION")
@Parcelize
data class ParcelableWeatherItem(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feels_like: @RawValue FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: @RawValue Temp,
    val weather: @RawValue List<WeatherObject>
) : Parcelable
