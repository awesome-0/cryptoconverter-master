package com.samuel.krypto.cryptoconverter.cards

interface addCardContract {
    interface View{
        fun cardExistsError()
        fun saveCardSuccess()
    }

    interface Presenter{
        fun saveCard(from: String, to: String)
        fun attachView(view: View)
        fun clearDisposables()
    }
}