package com.example.serraapp.data

import com.example.serraapp.R
import com.example.serraapp.model.TouristPlace

val places = listOf(
    TouristPlace(
        id = 1,
        name = "Pico Alto",
        category = "Mirante",
        description = "Vista incrível da serra",
        imageRes = R.drawable.pico_alto
    ),

    TouristPlace(
        id = 2,
        name = "Parque das Cachoeiras",
        category = "cachoeira",
        description = "cachoeira própria pra banho",
        imageRes = R.drawable.cachoeira
    ),
    TouristPlace(
        id = 3,
        name = "Casas Coloridas",
        category = "Arquitetura",
        description = "ótimo local para tirar foto",
        imageRes = R.drawable.casas_coloridas
    )
)