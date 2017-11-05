package com.samuel.krypto.cryptoconverter.cards

/**
 * Created by Oluwatimilehin on 30/10/2017.
 * oluwatimilehinadeniran@gmail.com.
 */
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