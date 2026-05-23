package com.example.serraapp.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Explore
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BottomBar(
    onExploreClick : () -> Unit,
    onFavoritesClick: () -> Unit,
    onProfileClick: () -> Unit
){
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = onExploreClick,

            icon = {
                Icon(
                    imageVector = Icons.Default.Explore,
                    contentDescription = "Explorar"
                )
            },
            label = {
                Text("Explorar")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = onFavoritesClick,

            icon = {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favoritos"
                )
            },
            label = {
                Text("Favoritos")
            }
        )
        NavigationBarItem(
            selected = false,
            onProfileClick,

            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Perfil"
                )
            },
            label = {
                Text("Perfil")
            }
        )
    }
}