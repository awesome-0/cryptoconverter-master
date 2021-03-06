package com.samuel.krypto.cryptoconverter.cards;

import com.samuel.krypto.cryptoconverter.network.Card



interface cardsContract {

    interface View{
        fun showEmptyCardsError()
        fun showEmptyCurrenciesError()
        fun currenciesExist()
        fun onDatabaseUpdateSuccess()
        fun showApiCallError()
        fun updateRecyclerView(cards: kotlin.collections.List<Card>)
        fun showAddCard()
        fun showCardDeleted()
        fun cardsExist()
        fun showConversionScreen(from: String, to: String, amount: Double)
    }

    interface Presenter{
        fun loadCurrencies(connected: Boolean)
        fun loadCards()
        fun attachView(view: cardsContract.View, connected: Boolean)
        fun clearDisposables()
        fun addNewCard()
        fun deleteCard(card: Card)
        fun loadDetails(card: Card)
        fun deleteAllCards()
    }
}
