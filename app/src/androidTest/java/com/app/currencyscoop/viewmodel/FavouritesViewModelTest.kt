package com.app.currencyscoop.viewmodel

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.currencyscoop.getOrAwaitValue
import com.app.currencyscoop.roomdatabase.entity.FavouritesEntity
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FavouritesViewModelTest{
    private lateinit var viewModel: FavouritesViewModel

    @get:Rule
    val instantTaskExecutorRule= InstantTaskExecutorRule()

    @Before
    fun setUp(){
        val application= ApplicationProvider.getApplicationContext<Application>()
        viewModel= FavouritesViewModel(application)
    }

    @Test
    fun addFavouriteTest(){
        viewModel.addFavourites(FavouritesEntity("USD"))
        val result=viewModel.allFavourites.getOrAwaitValue().find {
            it.currencyCode=="USD"
        }
        assertThat(result != null).isTrue()
    }

    @Test
    fun deleteFavouriteTest(){
        viewModel.deleteFavourites(FavouritesEntity("USD"))
        val result=viewModel.allFavourites.getOrAwaitValue().find {
            it.currencyCode=="USD"
        }
        assertThat(result != null).isTrue()
    }

}
