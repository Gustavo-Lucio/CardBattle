package com.example.heroicardgameapp.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.heroicardgameapp.R
import com.example.heroicardgameapp.services.model.CardGame
import com.example.heroicardgameapp.view.viewholder.CardGameViewHolder

class CardAdapter(var context: Context) : RecyclerView.Adapter<CardGameViewHolder>() {

    lateinit var listaCard : List<CardGame>
    var onItemLongClick : ((Int) -> Unit)? = null
    var onItemClick : ((Int) -> Unit)? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardGameViewHolder {
        val cardLayout = LayoutInflater.from(context)
            .inflate(R.layout.card_layout, parent, false)

        var holder = CardGameViewHolder(cardLayout)

        return holder
    }

    override fun getItemCount(): Int {
        return listaCard.size
    }

    override fun onBindViewHolder(holder: CardGameViewHolder, position: Int) {
        holder.txtNomeHeroi.text =    listaCard[position].nome
        holder.txtAtaqueHeroi.text =    listaCard[position].ataque.toString()
        holder.txtDefesaHeroi.text = listaCard[position].defesa.toString()

        holder.itemView.setOnLongClickListener {
            onItemLongClick?.invoke(position)
            true
        }

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(position)
        }
    }


    fun updateCard(list : List<CardGame>){
        listaCard = list
        notifyDataSetChanged()
    }


}