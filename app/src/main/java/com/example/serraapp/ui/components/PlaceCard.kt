package com.example.serraapp.ui.components

import com.example. serraapp.data.places
import com.example.serraapp.model.TouristPlace
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale

@Composable
fun PlaceCard(
    place: TouristPlace,
    onClick: () -> Unit,
    onFavoriteClick: () -> Unit
){
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(20.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = place.imageRes),
                contentDescription = place.name,

                contentScale = ContentScale.Crop,

                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = place.name,
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(
                        onClick = onFavoriteClick
                    ) {
                        Icon(
                            imageVector = if (place.isFavorite) Icons.Default.Favorite
                                            else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorito"
                        )
                    }
                }
                Text(
                    text = place.category,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}