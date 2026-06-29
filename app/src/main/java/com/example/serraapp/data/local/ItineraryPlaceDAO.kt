package com.example.serraapp.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryPlaceDAO {

    @Insert
    suspend fun insertItinerary(itineraryPlaceEntity: ItineraryPlaceEntity) : Long

    @Query("SELECT * FROM itinerary_places WHERE itineraryId = :itineraryId")
    suspend fun getPlacesByItinerary(itineraryId: Int): List<ItineraryPlaceEntity>

    @Query("DELETE FROM itinerary_places WHERE itineraryId = :itineraryId")
    suspend fun deleteByItinerary(itineraryId: Int)
}