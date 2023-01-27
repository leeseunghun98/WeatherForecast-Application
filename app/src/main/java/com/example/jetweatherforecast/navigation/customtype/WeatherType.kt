package com.example.jetweatherforecast.navigation.customtype

import android.os.Bundle
import androidx.navigation.NavType
import com.example.jetweatherforecast.model.ParcelableWeatherItem
import com.google.gson.Gson

class WeatherType : NavType<ParcelableWeatherItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): ParcelableWeatherItem? {
        return bundle.getParcelable(key)
    }
    override fun parseValue(value: String): ParcelableWeatherItem {
        return Gson().fromJson(value, ParcelableWeatherItem::class.java)
    }
    override fun put(bundle: Bundle, key: String, value: ParcelableWeatherItem) {
        bundle.putParcelable(key, value)
    }
}