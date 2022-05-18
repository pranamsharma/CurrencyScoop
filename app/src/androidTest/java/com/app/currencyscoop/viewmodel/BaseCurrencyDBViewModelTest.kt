package com.app.currencyscoop.viewmodel

import android.app.Application
import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.currencyscoop.getOrAwaitValue
import com.app.currencyscoop.roomdatabase.database.FavouritesDatabase
import com.app.currencyscoop.roomdatabase.entity.BaseCurrencyEntity
import com.app.currencyscoop.roomdatabase.repository.BaseCurrencyRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runner.manipulation.Ordering


@RunWith(AndroidJUnit4::class)
class BaseCurrencyDBViewModelTest{

    private lateinit var viewModel:BaseCurrencyDBViewModel

    @get:Rule
    val instantTaskExecutorRule=InstantTaskExecutorRule()

     @Before
    fun setUp(){

        val application=ApplicationProvider.getApplicationContext<Application>()

      viewModel=BaseCurrencyDBViewModel(application)

    }

    @Test
    fun testBaseCurrencyDBViewModel(){
        viewModel.addBaseCurrencyData(BaseCurrencyEntity("USD","INR"))
        val result=viewModel.allBaseCurrencyData.getOrAwaitValue().find {
            it.base_currency=="USD" && it.conversion_list=="INR"
        }
        assertThat(result!=null).isTrue()
    }

}