package com.example.heroicardgameapp.services.repository

import androidx.room.*
import com.example.heroicardgameapp.services.model.CardGame

@Dao
interface CardDAO {

    @Insert
    fun salvarCard(cardGame : CardGame) : Long

    @Delete
    fun excluirCard(cardGame: CardGame)

    @Update
    fun atualizarCard(cardGame: CardGame)

    @Query("SELECT * FROM cardGame WHERE id = :id")
    fun getCard(id : Int) : CardGame

    @Query("SELECT * FROM cardGame")
    fun getCards() : List<CardGame>

}