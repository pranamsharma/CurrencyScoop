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



}