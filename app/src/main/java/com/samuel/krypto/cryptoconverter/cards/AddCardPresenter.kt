package com.samuel.krypto.cryptoconverter.cards

import android.database.sqlite.SQLiteConstraintException
import com.mynameismidori.currencypicker.ExtendedCurrency
import com.samuel.krypto.cryptoconverter.App
import com.samuel.krypto.cryptoconverter.BasePresenter
import com.samuel.krypto.cryptoconverter.network.Card


class AddCardPresenter : addCardContract.Presenter, BasePresenter(){
    override fun clearDisposables() {
        disposables.clear()
    }

    override fun attachView(view: addCardContract.View) {
        this.addCardsView = view
        currencyDao = App.database.currencyDao()
        cardDao = App.database.cardDao()
    }

    override fun saveCard(from: String, to: String) {
        val currency: ExtendedCurrency = ExtendedCurrency.getCurrencyByName(to)

        disposables.add(currencyDao.getConversionRate(from, currency.code)
                .subscribeOn(scheduler)
                .subscribe({ amount ->
                    val flag = currency.flag
                    val name = currency.name

                    val card = Card(0, name, from, currency.code, amount, flag)

                    try {
                        cardDao.insert(card)
                        addCardsView.saveCardSuccess()

                    }catch (e: SQLiteConstraintException){
                        addCardsView.cardExistsError()
                    }
                })
        )


    }

}