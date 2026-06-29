package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serraapp.data.local.ItineraryEntity
import com.example.serraapp.data.places
import com.example.serraapp.model.Itinerary
import com.example.serraapp.repository.ItineraryRepository
import com.example.serraapp.ui.state.ItineraryUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ItineraryViewModel(
    private val repository: ItineraryRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(ItineraryUIState())

    val uiState: StateFlow<ItineraryUIState> = _uiState.asStateFlow()

    init {
        loadItineraries()
    }

    fun updateName(name: String){
        _uiState.value = _uiState.value.copy(itineraryName = name)
    }

    fun togglePlace(id: Int){
        val current = _uiState.value.selectedPlaces

        val updated =
            if (current.contains(id)){
                current - id
            }else {
                current + id
            }
        _uiState.value = _uiState.value.copy(selectedPlaces = updated)
    }

    fun saveItinerary(){
        val current = _uiState.value

        if (current.itineraryName.isBlank() || current.selectedPlaces.isEmpty()) return

            viewModelScope.launch {
                repository.insertItinerary(
                    ItineraryEntity(
                        name = current.itineraryName
                    )
                )
            }

        _uiState.value = current.copy(
            itineraryName = "",
            selectedPlaces = emptySet()
        )
    }

    private fun loadItineraries(){
        viewModelScope.launch {
            repository.getItineraries().collect { itineraries ->
                val itineraryList = itineraries.map { itinerary ->

                    Itinerary(
                        name = itinerary.name,
                        places = emptyList()
                    )
                }

                _uiState.value = _uiState.value.copy(
                    itineraries = itineraryList
                )
            }
        }
    }
}