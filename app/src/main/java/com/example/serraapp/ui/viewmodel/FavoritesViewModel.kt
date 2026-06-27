package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.serraapp.data.places
import com.example.serraapp.ui.state.FavoritesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class FavoritesViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        FavoritesUiState(favorites = places.take(2))
    )

    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()
}