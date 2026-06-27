package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.serraapp.data.places
import com.example.serraapp.model.Itineray
import com.example.serraapp.ui.state.ItineraryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ItineraryViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ItineraryUIState())

    val uiState: StateFlow<ItineraryUIState> = _uiState.asStateFlow()

    fun updateName(name: String){
        _uiState.value = _uiState.value.copy(itineraryName = name)
    }

    fun togglePlace(id: Int){
        val current = _uiState.value.selectedPlaces

        val updated =
            if (current.contains(id)){
                current - id
            }else {
                current + id;
            }
        _uiState.value = _uiState.value.copy(selectedPlaces = updated)
    }

    fun saveItinerary(){
        val current = _uiState.value

        if (current.itineraryName.isBlank() || current.selectedPlaces.isEmpty()) return

        val selected = places.filter {
            it.id in current.selectedPlaces
        }

        val newItinerary = Itineray(
            name = current.itineraryName,
            places = selected
        )

        _uiState.value = current.copy(
            itineraries = current.itineraries + newItinerary,
            itineraryName = "",
            selectedPlaces = emptySet()
        )
    }
}