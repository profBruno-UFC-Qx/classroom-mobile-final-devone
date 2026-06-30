package com.example.serraapp.repository

import com.example.serraapp.data.local.FavoriteDAO
import com.example.serraapp.data.local.FavoriteEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository(
    private val favoriteDAO: FavoriteDAO
) {

    fun getFavorites() = favoriteDAO.getFavorites()

    suspend fun insertFavorite(favoriteEntity: FavoriteEntity){
        favoriteDAO.insertFavorite(favoriteEntity)
    }

    suspend fun deleteFavorite(favoriteEntity: FavoriteEntity){
        favoriteDAO.deleteFavorite(favoriteEntity)
    }
}