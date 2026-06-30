package com.example.serraapp.network

import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    val main: Main,
    val weather: List<Weather>
)

@Serializable
data class Main (
    val temp: Double
)

@Serializable
data class Weather(
    val description: String
)