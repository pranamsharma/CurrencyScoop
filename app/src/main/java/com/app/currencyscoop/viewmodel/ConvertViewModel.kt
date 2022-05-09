package com.app.currencyscoop.viewmodel

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.MainCurrencyConvertModel
import com.app.currencyscoop.model.MainCurrencyRatesModel
import com.app.currencyscoop.retrofit.RetroInstance
import com.app.currencyscoop.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConvertViewModel:ViewModel() {

    var convertAmountResponse: MutableLiveData<MainCurrencyConvertModel> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<MainCurrencyConvertModel> {
        return convertAmountResponse
    }

    fun makeApiCall(api_key:String,from:String,to:String,amount:String,context: Activity)
    {
        val retroInstance= RetroInstance.getRetroInstance()
        val retrofitService=retroInstance.create(RetrofitService::class.java)
        val call=retrofitService.getCurrencyConvertValue(api_key,from,to,amount)

        Log.e("check",call.request().toString())
        call.enqueue(object : Callback<MainCurrencyConvertModel>
        {
            override fun onResponse(
                call: Call<MainCurrencyConvertModel>,
                response: Response<MainCurrencyConvertModel>
            ) {

                if (response.isSuccessful) {

                    AppUtils.alertSimple(context, response.body()!!.meta.code.toString())
                    Log.e("rates", response.body()!!.response.toString())
                    convertAmountResponse.postValue(response.body())
                }
                else
                {
                    AppUtils.alertSimple(context, response.body()!!.meta.code.toString())
                }
            }

            override fun onFailure(call: Call<MainCurrencyConvertModel>, t: Throwable) {
                AppUtils.alertSimple(context,t.message.toString())
                Log.e("failures",t.message.toString())
                convertAmountResponse.postValue(null)
            }
        })

    }
}