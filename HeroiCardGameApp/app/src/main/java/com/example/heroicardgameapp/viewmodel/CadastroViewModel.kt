package com.example.heroicardgameapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.heroicardgameapp.services.model.CardGame
import com.example.heroicardgameapp.services.model.ValidarCard
import com.example.heroicardgameapp.services.repository.CardRepository

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    private var txtToast = MutableLiveData<String>()
    private var validacao = ValidarCard()
    private var cardRepository = CardRepository(application.applicationContext)

    private var cardFromDB = MutableLiveData<CardGame>()

    fun getCardFromDB() : LiveData<CardGame>{
        return  cardFromDB
    }

    fun getTxtToast() : LiveData<String>{
        return  txtToast
    }

    fun salvarTarefa(nomeHeroi : String, ataqueHeroi : String, defesaHeroi : String) : Boolean {

        if (validacao.verificarCampoVazio(nomeHeroi, ataqueHeroi, defesaHeroi)){
            txtToast.value = "Informe todos os campos!"
            return false
        }

        if(validacao.verificaAtaque(ataqueHeroi)){
            txtToast.value = "Valor de ataque tem que ser maior que 0."
            return false
        }
        if(validacao.verificaDefesa(defesaHeroi)){
            txtToast.value = "Valor de defesa tem que ser maior que 0."
            return false
        }

        var card = CardGame(0, nomeHeroi, ataqueHeroi.toInt(), defesaHeroi.toInt())

        if(!cardRepository.salvarCard(card)){
            txtToast.value = "Falha ao salvar a carta no banco. Tente novamente mais tarde."
            return false
        }
        txtToast.value = "Carta cadastrada com sucesso!"
        return true
    }

    fun findCard(id: Int){
        cardFromDB.value = cardRepository.getCard(id)
    }

    fun atualizarCard(cardGame : CardGame) : Boolean{
        if(validacao.verificarCampoVazio(cardGame.nome, cardGame.ataque.toString(), cardGame.defesa.toString())){
            txtToast.value ="Informe todos os campos!"
            return false
        }
        cardRepository.atualizarCard(cardGame)
        txtToast.value = "Dados atualizados com sucesso!"
        return true
    }
}