package com.example.serraapp.repository

import com.example.serraapp.data.local.ItineraryDAO
import com.example.serraapp.data.local.ItineraryEntity

class ItineraryRepository(
    private val itineraryDAO: ItineraryDAO
) {
    fun getItineraries() = itineraryDAO.getItineraries()

    suspend fun insertItinerary(itineraryEntity: ItineraryEntity){
        itineraryDAO.insertItinerary(itineraryEntity)
    }

    suspend fun deleteItinerary(itineraryEntity: ItineraryEntity){
        itineraryDAO.deleteItinerary(itineraryEntity)
    }
}