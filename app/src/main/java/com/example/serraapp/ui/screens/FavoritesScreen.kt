package com.example.serraapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serraapp.data.local.FavoriteEntity
import com.example.serraapp.model.TouristPlace
import com.example.serraapp.ui.components.PlaceCard
import com.example.serraapp.ui.viewmodel.FavoritesViewModel
import com.example.serraapp.ui.viewmodel.PlaceViewModel

@Composable
fun FavoritesScreen(
    onPlaceClick: (TouristPlace) -> Unit,
    favoritesViewModel: FavoritesViewModel
){
    val uiState by favoritesViewModel.uiState.collectAsState()

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .padding(5.dp)
        ) {
            item {
                Text(
                    text = "Seus favoritos",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

            }
            items(uiState.favorites){ place ->
                PlaceCard(
                    place = place,
                    isFavorite = true,
                    onClick = {
                        onPlaceClick(place)
                    },
                    onFavoriteClick = {
                        favoritesViewModel.removeFavorite(FavoriteEntity(place.id))
                    }
                )

            }
        }
}