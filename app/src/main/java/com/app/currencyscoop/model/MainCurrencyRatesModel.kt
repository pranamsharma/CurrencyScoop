package com.app.currencyscoop.model

 data class MainCurrencyRatesModel(
    val meta: Meta,
    val response: Response
)

data class Meta(
    val code: Int,
    val disclaimer: String
)

data class Response(
    val base: String,
    val date: String,
    val rates: Rates
)

data class Rates(
    val ADA:Double,
    val AED:Double,
    val AFN:Double,
    val ALL:Double,
    val AMD:Double,
    val ANG:Double,
    val AOA:Double,
    val ARS:Double,
    val ATS:Double,
    val AUD:Double,
    val AWG:Double,
    val AZM:Double,
    val AZN:Double,
    val BAM:Double,
    val BBD:Double,
    val BCH:Double,
    val BDT:Double,
    val BEF:Double,
    val BGN:Double,
    val BHD:Double,
    val BIF:Double,
    val BMD:Double,
    val BND:Double,
    val BOB:Double,
    val BRL:Double,
    val BSD:Double,
    val BTN:Double,
    val BWP:Double,
    val BYN:Double,
    val BYR:Double,
    val BZD:Double,
    val CAD:Double,
    val CDF:Double,
    val CHF:Double,
    val CLF:Double,
    val CLP:Double,
    val CNH:Double,
    val CNY:Double,
    val COP:Double,
    val CRC:Double,
    val CUC:Double,
    val CUP:Double,
    val CVE:Double,
    val CZK:Double,
    val DEM:Double,
    val DJF:Double,
    val DKK:Double,
    val DOGE:Double,
    val DOP:Double,
    val DOT:Double,
    val DZD:Double,
    val EEK:Double,
    val EGP:Double,
    val ERN:Double,
    val ESP:Double,
    val ETB:Double,
    val ETH:Double,
    val EUR:Double,
    val FIM:Double,
    val FJD:Double,
    val FKP:Double,
    val FRF:Double,
    val GBP:Double,
    val GEL:Double,
    val GGP:Double,
    val GHC:Double,
    val GHS:Double,
    val GIP:Double,
    val GMD:Double,
    val GNF:Double,
    val GRD:Double,
    val GTQ:Double,
    val GYD:Double,
    val HKD:Double,
    val HNL:Double,
    val HRK:Double,
    val HTG:Double,
    val HUF:Double,
    val IDR:Double,
    val IEP:Double,
    val ILS:Double,
    val IMP:Double,
    val INR:Double,
    val IQD:Double,
    val IRR:Double,
    val ISK:Double,
    val ITL:Double,
    val JEP:Double,
    val JMD:Double,
    val JOD:Double,
    val KGS:Double,
    val KHR:Double,
    val KMF:Double,
    val KPW:Double,
    val KRW:Double,
    val KWD:Double,
    val KYD:Double,
    val KZT:Double,
    val LAK:Double,
    val LBP:Double,
    val LINK:Double,
    val LKR:Double,
    val LRD:Double,
    val LSL:Double,
    val LTC:Double,
    val LTL:Double,
    val LUF:Double,
    val LUNA:Double,
    val LVL:Double,
    val LYD:Double,
    val NAD:Double,
    val NGN:Double,
    val NIO:Double,
    val NLG:Double,
    val NOK:Double,
    val NPR:Double,
    val NZD:Double,
    val UAH:Double,
    val UGX:Double,
    val UNI:Double,
    val USD:Double,
    val UYU:Double,
    val UZS:Double,
    val WST:Double,
    val XAF:Double,
    val XAG:Double,

)


