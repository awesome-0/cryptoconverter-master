package com.samuel.krypto.cryptoconverter

import com.samuel.krypto.cryptoconverter.cards.addCardContract
import com.samuel.krypto.cryptoconverter.cards.cardsContract
import com.samuel.krypto.cryptoconverter.network.CardDao
import com.samuel.krypto.cryptoconverter.network.CurrencyDao
import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


abstract class BasePresenter{
    lateinit var cardsView: cardsContract.View;
    lateinit var addCardsView: addCardContract.View
    val disposables: CompositeDisposable = CompositeDisposable();
    val scheduler: Scheduler = Schedulers.single()
    lateinit var cardDao: CardDao
    lateinit var currencyDao: CurrencyDao
}