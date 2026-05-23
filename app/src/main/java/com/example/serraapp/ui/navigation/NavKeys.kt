package com.example.serraapp.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object ExploreKey : NavKey

@Serializable
data class DetailKey(
    val id: Int
) : NavKey