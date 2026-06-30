package com.example.serraapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ItineraryDAO {
    @Insert
    suspend fun insertItinerary(itineraryEntity: ItineraryEntity): Long

    @Query("DELETE FROM itineraries WHERE id = :id")
    suspend fun deleteItinerary(id: Int)

    @Query("SELECT * FROM itineraries")
    fun getItineraries(): Flow<List<ItineraryEntity>>
}