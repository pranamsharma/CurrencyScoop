package com.app.currencyscoop.viewmodel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrencyRatesViewModelTest{

    private lateinit var viewModel: CurrencyRatesViewModel

    @get:Rule
    val instantTaskExecutorRule=InstantTaskExecutorRule()

    @Before
    fun setUp(){
        viewModel= CurrencyRatesViewModel()
    }

    @Test
    fun testLiveDataObserver(){
        viewModel.getLiveDataObserver()
        val result=viewModel.currencyRatesList
        assertThat(result).isNotNull()
    }
}