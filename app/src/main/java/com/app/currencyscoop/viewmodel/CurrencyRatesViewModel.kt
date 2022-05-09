package com.app.currencyscoop.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.MainCurrencyRatesModel
import com.app.currencyscoop.retrofit.RetroInstance
import com.app.currencyscoop.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyRatesViewModel:ViewModel() {
      var currencyRatesList: MutableLiveData<MainCurrencyRatesModel> = MutableLiveData()

    fun getLiveDataObserver(): MutableLiveData<MainCurrencyRatesModel> {
        return currencyRatesList
    }

    fun makeApiCall(base_currency:String, context: Activity, viewModel: CurrencyRatesViewModel)
    {
         val retroInstance= RetroInstance.getRetroInstance()
        val retrofitService=retroInstance.create(RetrofitService::class.java)
        val call=retrofitService.getCurrencyRates(base_currency)

        Log.e("sadasdasdssada",call.request().toString())
        call.enqueue(object : Callback<MainCurrencyRatesModel>

        {
            override fun onResponse(
                call: Call<MainCurrencyRatesModel>,
                response: Response<MainCurrencyRatesModel>
            ) {
                if (response.isSuccessful) {
                    AppUtils.alertSimple(context, response.body()!!.meta.code.toString())
                    currencyRatesList.postValue(response.body())
                }

                else{
                AppUtils.alertErrorCurrencyRates(base_currency, context, response.body()!!.meta.code.toString(), viewModel)
            }
            }

            override fun onFailure(call: Call<MainCurrencyRatesModel>, t: Throwable) {
                Log.e("failuress",t.message.toString())
                currencyRatesList.postValue(null)
                AppUtils.alertErrorCurrencyRates(base_currency, context, t.message.toString(), viewModel)
            }
        })

    }
}