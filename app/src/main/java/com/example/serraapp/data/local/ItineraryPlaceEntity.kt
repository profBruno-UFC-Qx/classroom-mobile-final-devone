package com.example.serraapp.data.local

import androidx.room.Entity

@Entity(
    tableName = "itinerary_places",
    primaryKeys = ["itineraryId", "placeId"]
    )
data class ItineraryPlaceEntity(
    val itineraryId: Int,
    val placeId: Int
)
