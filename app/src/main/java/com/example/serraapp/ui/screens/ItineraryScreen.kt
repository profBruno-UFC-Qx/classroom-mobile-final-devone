package com.example.serraapp.ui.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import com.example.serraapp.model.TouristPlace
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serraapp.data.places
import com.example.serraapp.ui.viewmodel.ItineraryViewModel

@Composable
fun ItineraryScreen(
    onPlaceClick: (TouristPlace) -> Unit
){

    val viewModel: ItineraryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsState()

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
                    value = uiState.itineraryName,
                    onValueChange = {
                        viewModel.updateName(it)
                    },
                    label = {
                        Text("Nome do Roteiro")
                    }
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            item {
                Text(
                    text = "Locais disponíveis",
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            items(places) { place ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp, start = 4.dp, end = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(place.name)
                        Checkbox(
                            checked = place.id in uiState.selectedPlaces,
                            onCheckedChange = {
                                viewModel.togglePlace(place.id)
                            }
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Salvar roteiro")
                }
            }
        }
    }
}