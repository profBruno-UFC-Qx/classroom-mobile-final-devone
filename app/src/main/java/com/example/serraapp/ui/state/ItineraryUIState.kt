package com.example.serraapp.ui.state

import com.example.serraapp.model.Itinerary

data class ItineraryUIState (
    val itineraryName: String = "",
    val selectedPlaces: Set<Int> = emptySet(),
    val itineraries: List<Itinerary> = emptyList()
)