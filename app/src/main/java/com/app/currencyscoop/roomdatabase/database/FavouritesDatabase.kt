package com.app.currencyscoop.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.currencyscoop.roomdatabase.dao.BaseCurrencyDao
import com.app.currencyscoop.roomdatabase.dao.FavouritesDao
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity


@Database(entities = arrayOf(FavouritesEntity::class,BaseCurrencyEntity::class), version = 1, exportSchema = false)
abstract class FavouritesDatabase : RoomDatabase() {

    abstract fun getFavouritesDao(): FavouritesDao
    abstract fun getBaseCurrencyDao(): BaseCurrencyDao

    companion object {

        @Volatile
        private var INSTANCE: FavouritesDatabase? = null

        fun getDatabase(context: Context): FavouritesDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FavouritesDatabase::class.java,
                    "favourites_database"
                ).build()
                INSTANCE = instance
                 instance
            }
        }
    }
}