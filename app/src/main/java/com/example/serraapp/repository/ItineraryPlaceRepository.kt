package com.example.serraapp.repository

import com.example.serraapp.data.local.ItineraryPlaceDAO
import com.example.serraapp.data.local.ItineraryPlaceEntity

class ItineraryPlaceRepository(
    private val itineraryPlaceDAO: ItineraryPlaceDAO
) {
    suspend fun insert(
        itineraryPlaceEntity: ItineraryPlaceEntity
    ){
        itineraryPlaceDAO.insertItinerary(itineraryPlaceEntity)
    }

    suspend fun getPlacesFromItinerary(
        itineraryId: Int
    ): List<ItineraryPlaceEntity>{
        return itineraryPlaceDAO.getPlacesByItinerary(itineraryId)
    }

    suspend fun deleteByItinerary(
        itineraryId: Int
    ){
        itineraryPlaceDAO.deleteByItinerary(itineraryId)
    }
}