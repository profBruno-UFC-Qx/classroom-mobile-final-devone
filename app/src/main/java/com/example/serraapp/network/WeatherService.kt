package com.example.serraapp.network

import io.ktor.client.HttpClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class WeatherService(
    private val client: HttpClient
) {
    private val apiKey = "1010c9fac77a7358bd2e6dac2ed2ea51"

    suspend fun getWeather(city: String): WeatherResponse{
        return client.get("weather"){

            parameter("q", city)
            parameter("appid", apiKey)
            parameter("units", "metric")
            parameter("lang", "pt_br")
        }.body()
    }
}