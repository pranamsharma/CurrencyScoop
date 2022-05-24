package com.app.currencyscoop.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favourite :FavouritesEntity)

    @Delete
    suspend fun delete(favourite: FavouritesEntity)

    @Query("Select * from favourites order by id ASC")
    fun getAllFavourites(): LiveData<List<FavouritesEntity>>

    @Query("SELECT 1 FROM favourites WHERE currency_code = :currency_code")
    fun isDataExist(currency_code: String?): Boolean

    @Query("SELECT EXISTS (SELECT 1 FROM favourites WHERE currency_code = :currency_code)")
    fun isExists(currency_code: String?): Boolean


}