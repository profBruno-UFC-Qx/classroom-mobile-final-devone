package com.example.serraapp.model

data class Itinerary (
    val id: Int,
    val name: String,
    val places: List<TouristPlace>
)