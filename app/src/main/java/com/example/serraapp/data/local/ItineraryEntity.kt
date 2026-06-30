package com.example.serraapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "itineraries")
data class ItineraryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String
)
