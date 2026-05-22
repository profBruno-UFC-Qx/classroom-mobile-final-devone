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

@Composable
fun ExploreScreen(){
    Scaffold(
        topBar = {
            SerraTopBar()
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {}
            ) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding((paddingValues))
        ) {
            item{
                WeatherCard()
            }
            items(places){place ->
                PlaceCard(
                    place = place
                )
            }
        }
    }
}