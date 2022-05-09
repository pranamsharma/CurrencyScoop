package com.app.currencyscoop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.currencyscoop.roomdatabase.database.FavouritesDatabase
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.app.currencyscoop.roomdatabase.repository.FavouritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavouritesViewModel(application: Application) : AndroidViewModel(application) {


    val allFavourites : LiveData<List<FavouritesEntity>>
    private val repository : FavouritesRepository

    init {
        val dao = FavouritesDatabase.getDatabase(application).getFavouritesDao()
        repository = FavouritesRepository(dao)
        allFavourites = repository.allFavourites
    }


    fun deleteFavourites (favouritesEntity: FavouritesEntity)=

         viewModelScope.launch(Dispatchers.IO) {
            repository.delete(favouritesEntity)
        }


    fun addFavourites(favouritesEntity: FavouritesEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(favouritesEntity)
    }
}