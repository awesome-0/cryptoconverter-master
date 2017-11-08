package com.samuel.krypto.cryptoconverter.currencyconversion


interface ConversionContract{

    interface View{
        fun showAmount(amount: String, conversion: String)
    }

    interface Presenter{
        fun convertAmount(input: String, conversion: String)
        fun attachView(view: ConversionContract.View, rate: Double)
    }

}