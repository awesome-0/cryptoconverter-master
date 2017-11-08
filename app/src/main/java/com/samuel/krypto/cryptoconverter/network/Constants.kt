package com.samuel.krypto.cryptoconverter.network

import android.text.TextUtils
import com.mynameismidori.currencypicker.ExtendedCurrency


class Constants{

    companion object {

        val KEY_FROM = "from"
        val KEY_TO = "to"
        val KEY_AMOUNT = "amount"

        val listOfCurrencies: List<String> = listOf("EUR",
                "USD",
                "GBP",
                "CZK",
                "TRY",
                "JPY",
                "NGN",
                "AED",
                "AFN",
                "ARS",
                "AUD",
                "BDT",
                "BGN",
                "BHD",
                "BND",
                "BOB",
                "BRL",
                "BTN",
                "CAD",
                "CHF",
                "CLP",
                "CNY")

        val currenciesString: String = TextUtils.join(",", listOfCurrencies)

        fun getCurrenciesNames(): List<String>{
            val currencyNames: MutableList<String> = ArrayList<String>()

            val currencies = ExtendedCurrency.CURRENCIES
            var index = 0


            while (index < 24){
                if(currencies[index].code != "BMD" && currencies[index].code != "BZD" ) //These
                // are the currencies that there is no data for
                currencyNames.add(currencies[index].name)

                index++
            }

            currencyNames.add(0, "Nigeria Naira")

            return currencyNames
        }

    }


}