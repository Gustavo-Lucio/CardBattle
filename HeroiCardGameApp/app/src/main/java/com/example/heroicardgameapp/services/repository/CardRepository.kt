package com.example.heroicardgameapp.services.repository

import android.content.Context
import com.example.heroicardgameapp.services.model.CardGame

class CardRepository(var context : Context) {

    private val DAO = CardDataBase.getInstance(context).getDAO()

    fun salvarCard(cardGame: CardGame) : Boolean {
        return DAO.salvarCard(cardGame) >0
    }

    fun excluirCard(cardGame: CardGame){
        DAO.excluirCard(cardGame)
    }

    fun atualizarCard(cardGame: CardGame){
        DAO.atualizarCard(cardGame)
    }

    fun getCard(id : Int) :  CardGame{
        return DAO.getCard(id)
    }

    fun getCards(): List<CardGame>{
        return DAO.getCards()
    }
}