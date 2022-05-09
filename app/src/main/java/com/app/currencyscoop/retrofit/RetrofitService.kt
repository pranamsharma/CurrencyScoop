package com.app.currencyscoop.retrofit

import com.app.currencyscoop.model.MainCurrencyConvertModel
import com.app.currencyscoop.model.MainCurrencyListModel
import com.app.currencyscoop.model.MainCurrencyRatesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    //@Query("api_key") apiKey: String ,@Query("type") type: String
    @GET("currencies?api_key=422ffc3866e625a5989e3fac8a2486e7&type=fiat")
    fun getCurrencyList():Call<MainCurrencyListModel>

    @GET("latest?api_key=422ffc3866e625a5989e3fac8a2486e7&base")
    fun getCurrencyRates(
        @Query("base") currency: String
    ): Call<MainCurrencyRatesModel>


   @GET("convert?")
    fun getCurrencyConvertValue(
        @Query("api_key") api_key: String,
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("amount") amount: String
   ): Call<MainCurrencyConvertModel>

}