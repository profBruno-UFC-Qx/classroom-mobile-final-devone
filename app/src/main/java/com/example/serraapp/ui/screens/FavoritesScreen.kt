package com.example.serraapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.serraapp.data.places
import com.example.serraapp.model.TouristPlace
import com.example.serraapp.ui.components.PlaceCard

@Composable
fun FavoritesScreen(
    onPlaceClick: (TouristPlace) -> Unit
){
    val favoritePlaces = places.take(2)

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
            items(favoritePlaces){ place ->
                PlaceCard(
                    place = place,
                    onClick = {
                        onPlaceClick(place)
                    }
                )

            }
        }
}