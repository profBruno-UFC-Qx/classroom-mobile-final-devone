package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.serraapp.data.places
import com.example.serraapp.ui.state.PlaceUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class PlaceViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        PlaceUiState(places = places)
    )

    val uiState: StateFlow<PlaceUiState> = _uiState.asStateFlow()

    fun toggleFavorite(id: Int){
        _uiState.value = _uiState.value.copy(
            places = _uiState.value.places.map { place ->
                if (place.id == id){
                    place.copy(isFavorite = !place.isFavorite)
                }else{
                    place
                }
            }
        )
    }
}