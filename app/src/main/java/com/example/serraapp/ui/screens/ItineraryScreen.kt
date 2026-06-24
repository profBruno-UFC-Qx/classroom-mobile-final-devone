package com.example.serraapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import com.example.serraapp.model.TouristPlace
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment

@Composable
fun ItineraryScreen(
    onPlaceClick: (TouristPlace) -> Unit
){
    var nameItinerary by remember {
        mutableStateOf("")
    }
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = "Crie seu Roteiro",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            item {
                TextField(
                    value = nameItinerary,
                    onValueChange = {
                        nameItinerary = it
                    },
                    label = {
                        Text("Nome do Roteiro")
                    }
                )
            }
        }
    }
}