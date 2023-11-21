package com.example.heroicardgameapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.heroicardgameapp.services.model.CardGame
import com.example.heroicardgameapp.services.repository.CardRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var listaCard = MutableLiveData<List<CardGame>>()
    private var repository = CardRepository(application.applicationContext)
    private  var txtToast = MutableLiveData<String>()

    fun getListaCard() : LiveData<List<CardGame>>{
        return  listaCard
    }

    fun getTxtToast() : LiveData<String>{
        return  txtToast
    }

    fun getListaFromDB(){
        listaCard.value = repository.getCards()
    }

    fun excluirCard(cardGame: CardGame){
        repository.excluirCard(cardGame)
        txtToast.value = "Tarefa Excluída com sucesso!"
    }
}