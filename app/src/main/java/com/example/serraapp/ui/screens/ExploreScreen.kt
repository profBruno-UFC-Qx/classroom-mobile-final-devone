package com.example.serraapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.serraapp.data.places
import com.example.serraapp.ui.components.PlaceCard
import com.example.serraapp.ui.components.SerraTopBar
import com.example.serraapp.ui.components.WeatherCard
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serraapp.data.local.FavoriteEntity
import com.example.serraapp.model.TouristPlace
import com.example.serraapp.network.KtorClient
import com.example.serraapp.network.WeatherService
import com.example.serraapp.repository.WeatherRepository
import com.example.serraapp.ui.viewmodel.FavoritesViewModel
import com.example.serraapp.ui.viewmodel.PlaceViewModel
import com.example.serraapp.ui.viewmodel.WeatherViewModel
import com.example.serraapp.ui.viewmodel.WeatherViewModelFactory

@Composable
fun ExploreScreen(
    favoritesViewModel: FavoritesViewModel,
    onPlaceClick: (TouristPlace) -> Unit
){
    val placeViewModel: PlaceViewModel = viewModel()
    val placeUiState by placeViewModel.uiState.collectAsState()

    val favoritesUiState by favoritesViewModel.uiState.collectAsState()

    val repository = remember {
        WeatherRepository(WeatherService(KtorClient.api))
    }

    val weatherViewModel: WeatherViewModel = viewModel(
        factory = WeatherViewModelFactory(repository)
    )

    val temp by weatherViewModel.temp.collectAsState()
    val desc by weatherViewModel.desc.collectAsState()

    LaunchedEffect(Unit) {
        weatherViewModel.loadWeather("Guaramiranga")
    }
    LazyColumn () {
            item{
                WeatherCard(
                    city = "Guaramiranga, CE",
                    temp = temp ?: 0.0,
                    description = desc.ifBlank{ "Carregando..." }
                )
            }
            items(placeUiState.places){place ->
                PlaceCard(
                    place = place,
                    isFavorite = favoritesUiState.favorites.any {
                        it.id == place.id
                    },
                    onClick = {
                        onPlaceClick(place)
                    },
                    onFavoriteClick = {
                        if (favoritesUiState.favorites.any { it.id == place.id }){
                            favoritesViewModel.removeFavorite(FavoriteEntity(place.id))
                        } else {
                            favoritesViewModel.insertFavorite(FavoriteEntity(place.id))
                        }
                    }
                )
            }
        }
}