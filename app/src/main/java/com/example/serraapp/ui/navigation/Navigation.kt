package com.example.serraapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.serraapp.data.local.DatabaseProvider
import com.example.serraapp.data.places
import com.example.serraapp.repository.FavoriteRepository
import com.example.serraapp.repository.ItineraryRepository
import com.example.serraapp.ui.components.BottomBar
import com.example.serraapp.ui.components.SerraTopBar
import com.example.serraapp.ui.screens.ExploreScreen
import com.example.serraapp.ui.screens.DetailScreen
import com.example.serraapp.ui.screens.FavoritesScreen
import com.example.serraapp.ui.screens.ItineraryScreen
import com.example.serraapp.ui.screens.ProfileScreen
import com.example.serraapp.ui.viewmodel.FavoriteViewModelFactory
import com.example.serraapp.ui.viewmodel.FavoritesViewModel
import com.example.serraapp.ui.viewmodel.ItineraryViewModel
import com.example.serraapp.ui.viewmodel.ItineraryViewModelFactory

@Composable
fun Navigation(
    modifier : Modifier = Modifier
){
    val backStack = rememberNavBackStack(ExploreKey)
    var currentScreen by remember {
        mutableStateOf("explore")
    }

    val context = LocalContext.current
    val database = DatabaseProvider.getDatabase(context)
    val repository = FavoriteRepository(database.favoriteDAO())
    val favoritesViewModel: FavoritesViewModel = viewModel(
        factory = FavoriteViewModelFactory(repository)
    )
    val itineraryRepository = ItineraryRepository(database.ItineraryDAO())
    val itineraryViewModel: ItineraryViewModel = viewModel(
        factory = ItineraryViewModelFactory(itineraryRepository)
    )

    Scaffold(
        topBar = {
            SerraTopBar()
        },

        bottomBar = {
            BottomBar(
                currentScreen = currentScreen,
                onExploreClick = {
                    currentScreen = "explore"
                    backStack.clear()
                    backStack.add(ExploreKey)
                },
                onFavoritesClick = {
                    currentScreen = "favorites"
                    backStack.clear()
                    backStack.add(FavoritesKey)
                },
                onItineraryClick = {
                    currentScreen = "itinerary"
                    backStack.clear()
                    backStack.add(ItineraryKey)
                },
                onProfileClick = {
                    currentScreen  = "profile"
                    backStack.clear()
                    backStack.add(ProfileKey)
                }
            )
        },
        floatingActionButton = {
            if(currentScreen == "explore"){
                FloatingActionButton(
                    onClick = {}
                ) {
                    Text("+")
                }
            }
        }
    ){ paddingValues ->
        NavDisplay(
            backStack = backStack,
            entryProvider = entryProvider {
                entry<ExploreKey>{
                    ExploreScreen(
                        favoritesViewModel = favoritesViewModel,
                        onPlaceClick = { place ->
                            backStack.add(
                                DetailKey(place.id)
                            )
                        }
                    )
                }
                entry<DetailKey> {
                    val place = places.first { place ->
                        place.id == it.id
                    }
                    DetailScreen(
                        place = place,
                        onBack = {
                            backStack.removeLastOrNull()
                        }
                    )
                }
                entry<FavoritesKey>{
                    FavoritesScreen(
                        favoritesViewModel = favoritesViewModel,
                        onPlaceClick = { place ->
                            backStack.add(
                                DetailKey(place.id)
                            )
                        }
                    )
                }
                entry<ItineraryKey>{
                    ItineraryScreen(
                        itineraryViewModel = itineraryViewModel,
                        onPlaceClick = { place ->
                            backStack.add(
                                DetailKey(place.id)
                            )
                        }
                    )
                }
                entry<ProfileKey>{
                    ProfileScreen()
                }
            },
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )
    }
}