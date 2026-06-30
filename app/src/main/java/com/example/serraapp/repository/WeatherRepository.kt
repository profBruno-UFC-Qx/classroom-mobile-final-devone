package com.example.serraapp.repository

import com.example.serraapp.network.WeatherService

class WeatherRepository(
    private val service: WeatherService
) {
    suspend fun getWeather(city: String) = service.getWeather(city)
}