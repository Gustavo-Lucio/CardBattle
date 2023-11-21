package com.example.heroicardgameapp.services.model

class ValidarCard {

    fun verificarCampoVazio(nomeCard : String, ataqueCard : String, defesaCard : String) : Boolean {
       if(nomeCard.isEmpty() || ataqueCard.isEmpty() || defesaCard.isEmpty()){
           return true
       }
        return false
    }

    fun verificaAtaque(ataqueCard: String) : Boolean {
        if(ataqueCard.toInt() < 0){
            return true
        }
        return false
    }

    fun verificaDefesa(defesaCard: String) : Boolean {
        if(defesaCard.toInt() < 0){
            return true
        }
        return false
    }

}