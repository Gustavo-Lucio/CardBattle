package com.example.heroicardgameapp.services.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.heroicardgameapp.services.model.CardGame

@Database(entities =  [CardGame::class], version = 1)
abstract class CardDataBase : RoomDatabase(){

    abstract fun getDAO(): CardDAO

    companion object {

        private  lateinit var INSTANCE : CardDataBase

        fun getInstance(context: Context) : CardDataBase {
            if(!Companion::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(context, CardDataBase::class.java, "card_game_db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE
        }
    }
}