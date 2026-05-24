package com.example.serraapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.serraapp.data.places
import com.example.serraapp.model.TouristPlace
import com.example.serraapp.ui.components.BottomBar
import com.example.serraapp.ui.components.PlaceCard
import com.example.serraapp.ui.components.SerraTopBar

@Composable
fun FavoritesScreen(
    onPlaceClick: (TouristPlace) -> Unit
){
    val favoritePlaces = places.take(2)

    Scaffold() { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            item {
                Text("Seus favoritos")

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
}