package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
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
}