package com.example.serraapp.ui.state

import com.example.serraapp.model.TouristPlace

data class FavoritesUiState(
    val favorites: List<TouristPlace> = emptyList()
)