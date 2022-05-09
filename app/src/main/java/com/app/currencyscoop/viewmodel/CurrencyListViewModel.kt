package com.app.currencyscoop.viewmodel

import android.app.Activity
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.currencyscoop.R
import com.app.currencyscoop.apputils.AppUtils
import com.app.currencyscoop.model.MainCurrencyListModel
import com.app.currencyscoop.retrofit.RetroInstance
import com.app.currencyscoop.retrofit.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrencyListViewModel:ViewModel() {

    lateinit var liveDataList: MutableLiveData<MainCurrencyListModel>
    init {
        liveDataList= MutableLiveData()
    }

    fun getLiveDataObserver():MutableLiveData<MainCurrencyListModel>{
        return liveDataList
    }

    fun makeApiCall(context: Activity,viewModel: CurrencyListViewModel)
    {

        val retroInstance=RetroInstance.getRetroInstance()
        val retrofitService=retroInstance.create(RetrofitService::class.java)
        val call=retrofitService.getCurrencyList()

        Log.e("sadasdasdssada",call.request().toString())
        call.enqueue(object : Callback<MainCurrencyListModel>

        {
            override fun onResponse(
                call: Call<MainCurrencyListModel>,
                response: Response<MainCurrencyListModel>
            ) {
                if (response.isSuccessful) {
                    AppUtils.alertSimple(context, response.body()!!.meta.code.toString())
                    Log.e("dadadadad", response.body()!!.response.fiats.toString())
                    liveDataList.postValue(response.body())
                }else
                {
                    AppUtils.alertSimple(context, response.body()!!.meta.code.toString())

                    AppUtils.alertError(context,response.body()!!.meta.code.toString(),viewModel)
                }
            }

            override fun onFailure(call: Call<MainCurrencyListModel>, t: Throwable) {
                Log.e("failuress",t.message.toString())
                liveDataList.postValue(null)
            }
        })

    }
}