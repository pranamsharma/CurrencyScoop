package com.app.currencyscoop.roomdatabase.repository

import androidx.lifecycle.LiveData
import com.app.currencyscoop.roomdatabase.dao.BaseCurrencyDao
import com.app.currencyscoop.roomdatabase.dao.FavouritesDao
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity

class BaseCurrencyRepository(private val baseCurrencyDao: BaseCurrencyDao) {


    val allBaseCurrencyData: LiveData<List<BaseCurrencyEntity>> = baseCurrencyDao.getAllBaseCurrencyData()

    suspend fun insert(baseCurrencyEntity: BaseCurrencyEntity) {
        baseCurrencyDao.insert(baseCurrencyEntity)
    }


    suspend fun delete(baseCurrencyEntity: BaseCurrencyEntity){
        baseCurrencyDao.delete(baseCurrencyEntity)
    }


}