package com.samuel.krypto.cryptoconverter.network

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "cards",
        indices = arrayOf(Index(value = *arrayOf("from", "to"),
                unique = true)
        ))
data class Card(@PrimaryKey(autoGenerate = true)
                val uid: Long = 0,
                @ColumnInfo(name = "currency_name")
                val currencyName: String,
                val from: String, val to: String, val
                amount: Double,
                val flag: Int
) {
};