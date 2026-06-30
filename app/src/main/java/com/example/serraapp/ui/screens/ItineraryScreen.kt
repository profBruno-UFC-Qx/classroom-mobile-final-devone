package com.example.serraapp.ui.screens

import android.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Route
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serraapp.data.places
import com.example.serraapp.ui.viewmodel.ItineraryViewModel

@Composable
fun ItineraryScreen(
    itineraryViewModel: ItineraryViewModel,
    onPlaceClick: (TouristPlace) -> Unit
){

    val uiState by itineraryViewModel.uiState.collectAsState()

    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        Icons.Default.Route,
                        contentDescription = "Ícone de Rotas, roteiro"
                    )
                    Spacer(modifier= Modifier.width(8.dp))

                    Text(
                        text = "Crie seu Roteiro",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            item {
                TextField(
                    value = uiState.itineraryName,
                    onValueChange = {
                        itineraryViewModel.updateName(it)
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
                                itineraryViewModel.togglePlace(place.id)
                            }
                        )
                    }
                }
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
                Text("Locais selecionados: ${uiState.selectedPlaces.size}")
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Button(
                    enabled = uiState.itineraryName.isNotBlank() && uiState.selectedPlaces.isNotEmpty(),
                    onClick = {
                        itineraryViewModel.saveItinerary()
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Salvar roteiro")
                }
            }
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Meus roteiros",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            items(uiState.itineraries){ itinerary ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                    ) {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = itinerary.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            IconButton(
                                onClick = {
                                    itineraryViewModel.deleteItinerary(itinerary.id)
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = "Deletar roteiro"
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        itinerary.places.forEach { place ->
                            Text("• ${place.name}")
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

        }
    }
}