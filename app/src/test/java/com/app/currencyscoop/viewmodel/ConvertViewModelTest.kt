package com.app.currencyscoop.viewmodel

import android.app.Activity
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test



class ConvertViewModelTest{

    private lateinit var viewModel:ConvertViewModel

    @get:Rule
    val instantTaskExecutorRule= InstantTaskExecutorRule()

    @Before
    fun setUp(){
        viewModel= ConvertViewModel()
    }

    @Test
    fun testConvertAmountResponce(){
        viewModel.getLiveDataObserver()
        val result=viewModel.convertAmountResponse
        assertThat(result.equals("USA")).isFalse()
    }

    @Test
     fun testMakeApiCalls(){
         viewModel.makeApiCall("422ffc3866e625a5989e3fac8a2486e7","USD","INR","1", Activity())
        val result= viewModel.getLiveDataObserver()
         assertThat(result!==null).isTrue()
     }




}