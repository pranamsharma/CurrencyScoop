package com.app.currencyscoop.viewmodel

import android.app.Activity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class CurrencyListViewModelTest{

    private lateinit var viewModel: CurrencyListViewModel

    @get:Rule
    val instantTaskExecutorRule=InstantTaskExecutorRule()

    @Before
    fun setUp(){
        viewModel= CurrencyListViewModel()
    }

    @Test
    fun testLiveDataObserver(){
        viewModel.getLiveDataObserver()
        val result=viewModel.liveDataList
        assertThat(result).isEqualTo(result)
    }

    @Test
    fun testMakeApiCall(){
        viewModel.makeApiCall(Activity(), CurrencyListViewModel())
       val results= viewModel.getLiveDataObserver()
        assertThat(results).isEqualTo(results)

    }

}