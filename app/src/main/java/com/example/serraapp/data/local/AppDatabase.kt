package com.example.serraapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        FavoriteEntity::class,
        ItineraryEntity::class,
        ItineraryPlaceEntity::class
               ],
    version = 3,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase(){
    abstract fun favoriteDAO() : FavoriteDAO

    abstract fun itineraryDAO(): ItineraryDAO

    abstract fun itineraryPlaceDAO(): ItineraryPlaceDAO
}
