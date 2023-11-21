package com.example.heroicardgameapp.services.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "cardGame")
data class CardGame (
   @ColumnInfo @PrimaryKey(autoGenerate = true) var id : Int,
   @ColumnInfo var nome : String,
   @ColumnInfo var ataque: Int,
   @ColumnInfo var defesa : Int
)