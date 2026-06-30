package com.example.serraapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.serraapp.data.local.FavoriteEntity
import com.example.serraapp.data.places
import com.example.serraapp.repository.FavoriteRepository
import com.example.serraapp.ui.state.FavoritesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: FavoriteRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(
        FavoritesUiState()
    )

    val uiState: StateFlow<FavoritesUiState> = _uiState.asStateFlow()

    init {
        loadFavorites()
    }

    private fun loadFavorites(){
        viewModelScope.launch {
            repository.getFavorites().collect { favorites ->
                val favoritePlaces = favorites.mapNotNull { favorite ->
                    places.find { place ->
                        place.id == favorite.id
                    }
                }

                _uiState.value = _uiState.value.copy(favorites = favoritePlaces)
            }
        }
    }

    fun insertFavorite(favoriteEntity: FavoriteEntity){
        viewModelScope.launch {
            repository.insertFavorite(favoriteEntity)
        }
    }

    fun removeFavorite(favoriteEntity: FavoriteEntity){
        viewModelScope.launch {
            repository.deleteFavorite(favoriteEntity)
        }
    }

    fun isFavorite(id: Int): Boolean{
        return uiState.value.favorites.any {
            it.id == id
        }
    }
}