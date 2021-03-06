package com.samuel.krypto.cryptoconverter.network

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import io.reactivex.Single



@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCurrencies(currencies: List<Currency>)

    @Query("SELECT amount from currencies WHERE \"from\" = :from AND \"to\" = :to")
    fun getConversionRate(from: String, to: String): Single<Double>

    @Query("SELECT * from currencies")
    fun getAllCurrencies(): Flowable<List<Currency>>

    @Query("SELECT * from currencies")
    fun checkIfCurrenciesExist(): Single<List<Currency>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrency(currency: Currency)

}