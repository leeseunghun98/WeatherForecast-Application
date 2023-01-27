package com.example.jetweatherforecast.utils

import com.example.jetweatherforecast.model.ParcelableWeatherItem
import com.example.jetweatherforecast.model.Weather
import com.example.jetweatherforecast.model.WeatherItem

fun parcelWeatherConverter(
    weatherItem: WeatherItem
): ParcelableWeatherItem {
    return ParcelableWeatherItem(
        clouds = weatherItem.clouds,
        deg = weatherItem.deg,
        dt = weatherItem.dt,
        feels_like = weatherItem.feels_like,
        gust = weatherItem.gust,
        humidity = weatherItem.humidity,
        pop = weatherItem.pop,
        pressure = weatherItem.pressure,
        rain = weatherItem.rain,
        speed = weatherItem.speed,
        sunrise = weatherItem.sunrise,
        sunset = weatherItem.sunset,
        temp = weatherItem.temp,
        weather = weatherItem.weather
    )
}

fun WeatherItemConverter(parcelableWeatherItem: ParcelableWeatherItem) : WeatherItem{
    return WeatherItem(
        clouds = parcelableWeatherItem.clouds,
        deg = parcelableWeatherItem.deg,
        dt = parcelableWeatherItem.dt,
        feels_like = parcelableWeatherItem.feels_like,
        gust = parcelableWeatherItem.gust,
        humidity = parcelableWeatherItem.humidity,
        pop = parcelableWeatherItem.pop,
        pressure = parcelableWeatherItem.pressure,
        rain = parcelableWeatherItem.rain,
        speed = parcelableWeatherItem.speed,
        sunrise = parcelableWeatherItem.sunrise,
        sunset = parcelableWeatherItem.sunset,
        temp = parcelableWeatherItem.temp,
        weather = parcelableWeatherItem.weather
    )
}