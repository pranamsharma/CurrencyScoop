package com.app.currencyscoop.model

data class MainCurrencyConvertModel(
    val meta: CurrencyClass.Meta,
    val response: CurrencyClass.Response
)

class CurrencyClass{
    data class Meta(
        val code: Int,
        val disclaimer: String
    )

    data class Response(
        val amount: Int,
        val date: String,
        val from: String,
        val timestamp: Int,
        val to: String,
        val value: Double
    )
}
