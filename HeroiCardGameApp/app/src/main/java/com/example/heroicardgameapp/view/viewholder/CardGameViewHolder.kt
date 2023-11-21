package com.example.heroicardgameapp.view.viewholder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.heroicardgameapp.R

class CardGameViewHolder(cardLayout: View) : RecyclerView.ViewHolder(cardLayout) {
    var txtNomeHeroi = cardLayout.findViewById<TextView>(R.id.txtNomeHeroi)
    var txtAtaqueHeroi = cardLayout.findViewById<TextView>(R.id.txtAtaqueHeroi)
    var txtDefesaHeroi = cardLayout.findViewById<TextView>(R.id.txtDefesaHeroi)
}