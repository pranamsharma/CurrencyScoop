package com.app.currencyscoop.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity

@Dao
interface BaseCurrencyDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(baseCurrencyEntity: BaseCurrencyEntity)

    @Delete
    suspend fun delete(baseCurrencyEntity: BaseCurrencyEntity)


    @Query("Select * from base_currency order by id ASC")
    fun getAllBaseCurrencyData(): LiveData<List<BaseCurrencyEntity>>



}