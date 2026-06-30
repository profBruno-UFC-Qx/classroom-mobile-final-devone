package com.example.serraapp.model

data class TouristPlace(
    val id: Int,
    val name: String,
    val category: String,
    val description: String,
    val imageRes: Int,
    val isFavorite: Boolean = false
)