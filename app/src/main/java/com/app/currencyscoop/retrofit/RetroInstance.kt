package com.app.currencyscoop.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {

    companion object{
        val BASE_URL="https://api.currencyscoop.com/v1/" //currencies?
        fun getRetroInstance():Retrofit{

            return  Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }


}