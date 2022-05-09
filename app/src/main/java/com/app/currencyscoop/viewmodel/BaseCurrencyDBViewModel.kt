package com.app.currencyscoop.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.currencyscoop.roomdatabase.database.FavouritesDatabase
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.app.currencyscoop.roomdatabase.repository.BaseCurrencyRepository
import com.app.currencyscoop.roomdatabase.repository.FavouritesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BaseCurrencyDBViewModel(application: Application) : AndroidViewModel(application) {


    val allBaseCurrencyData : LiveData<List<BaseCurrencyEntity>>
    val repository : BaseCurrencyRepository

    init {
        val dao = FavouritesDatabase.getDatabase(application).getBaseCurrencyDao()
        repository = BaseCurrencyRepository(dao)
        allBaseCurrencyData = repository.allBaseCurrencyData
    }


    fun deleteBaseCurrencyData(baseCurrencyEntity: BaseCurrencyEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(baseCurrencyEntity)
    }

    fun addBaseCurrencyData(baseCurrencyEntity: BaseCurrencyEntity) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(baseCurrencyEntity)
    }
}