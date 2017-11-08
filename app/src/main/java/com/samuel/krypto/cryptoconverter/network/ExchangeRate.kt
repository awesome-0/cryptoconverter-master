package com.samuel.krypto.cryptoconverter.network

import com.google.gson.annotations.SerializedName


data class ExchangeRate(
        @SerializedName("ETH")
        val ethRates: HashMap<String, Double>,

        @SerializedName("BTC")
        val btcRates: HashMap<String, Double>
)

