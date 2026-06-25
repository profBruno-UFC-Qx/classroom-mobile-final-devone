package com.example.serraapp.ui.state

data class ItineraryUIState (
    val itineraryName: String = "",
    val selectedPlaces: Set<Int> = emptySet()
)