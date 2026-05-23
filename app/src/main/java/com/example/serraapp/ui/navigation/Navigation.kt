package com.example.serraapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.serraapp.data.places
import com.example.serraapp.ui.screens.ExploreScreen
import com.example.serraapp.ui.screens.DetailScreen

@Composable
fun Navigation(
    modifier : Modifier = Modifier
){
    val backStack = rememberNavBackStack(ExploreKey)

    NavDisplay(
        backStack = backStack,
        entryProvider = entryProvider {
            entry<ExploreKey>{
                ExploreScreen(
                    onPlaceClick = { place ->
                        backStack.add(
                            DetailKey(place.id)
                        )
                    }
                )
            }
            entry<DetailKey>{
                val place = places.first{ place ->
                    place.id == it.id
                }
                DetailScreen(
                    place = place,
                    onBack = {
                        backStack.removeLastOrNull()
                    }
                )
            }
        },
        modifier = modifier.fillMaxSize()
    )
}