package com.app.currencyscoop.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.app.currencyscoop.roomdatabase.dao.FavouritesDao
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity

class FavouritesRepository(private val favouritesDao: FavouritesDao) {


    val allFavourites: LiveData<List<FavouritesEntity>> = favouritesDao.getAllFavourites()

    suspend fun insert(favouritesEntity: FavouritesEntity) {
        favouritesDao.insert(favouritesEntity)
    }


    suspend fun delete(favouritesEntity: FavouritesEntity){
        favouritesDao.delete(favouritesEntity)
    }


}