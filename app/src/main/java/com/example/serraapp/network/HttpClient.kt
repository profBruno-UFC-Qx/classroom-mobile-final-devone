package com.example.serraapp.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType.Application.Json
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorClient {
    val api: HttpClient by lazy {
        HttpClient(Android){
            install(ContentNegotiation){
                json(
                    Json{
                        ignoreUnknownKeys = true
                        prettyPrint = true
                    }
                )
            }

            install(Logging){
                level = LogLevel.BODY
            }

            defaultRequest {
                url("https://api.openweathermap.org/data/2.5/")
            }
        }
    }
}