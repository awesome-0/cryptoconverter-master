package com.samuel.krypto.cryptoconverter.network

import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit



interface CryptoCompareService {
    @GET("data/pricemulti?fsyms=BTC,ETH")
    fun getRates(@Query("tsyms") tsyms : String) : Single<ExchangeRate>


    /**
     * Companion object to create the CryptoCompareService
     */
    companion object Factory {
        fun create() : CryptoCompareService{

            val okHttpClient = OkHttpClient().newBuilder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(45, TimeUnit.SECONDS)
                    .writeTimeout(45, TimeUnit.SECONDS)
                    .build()

            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .baseUrl("https://min-api.cryptocompare.com/")
                    .build()

            return  retrofit.create(CryptoCompareService::class.java)
        }
    }
}