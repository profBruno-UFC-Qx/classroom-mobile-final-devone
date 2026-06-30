package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.serraapp.repository.ItineraryPlaceRepository
import com.example.serraapp.repository.ItineraryRepository

class ItineraryViewModelFactory(
    private val repository: ItineraryRepository,
    private val itineraryPlaceRepository: ItineraryPlaceRepository
): ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if (modelClass.isAssignableFrom(ItineraryViewModel::class.java)){
            return ItineraryViewModel(repository, itineraryPlaceRepository) as T
        }

        throw IllegalArgumentException("ViewModel desconhecido")
    }
}