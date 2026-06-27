package com.example.serraapp.ui.state

import com.example.serraapp.model.TouristPlace

data class PlaceUiState(
    val places: List<TouristPlace> = emptyList()
)
