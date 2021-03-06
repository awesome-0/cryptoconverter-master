package com.samuel.krypto.cryptoconverter.network

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "currencies",
        indices = arrayOf(Index(value = *arrayOf("from","to"),
        unique = true)
        ))
data class Currency(
        @PrimaryKey(autoGenerate = true)
        val uid: Long = 0,
        val from: String,
        val to: String,
        val amount: Double
){
       @Ignore constructor(): this(0, "", "", 0.0)
}