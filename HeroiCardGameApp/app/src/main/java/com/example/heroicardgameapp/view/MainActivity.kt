package com.example.heroicardgameapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.heroicardgameapp.R
import com.example.heroicardgameapp.databinding.ActivityMainBinding
import com.example.heroicardgameapp.view.adapter.CardAdapter
import com.example.heroicardgameapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CardAdapter
    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = CardAdapter(this)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.rcvCards.layoutManager = LinearLayoutManager(this)

        setObservers()
        setAdapter()

        binding.btnNovoCard.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    fun setObservers(){
        viewModel.getListaCard().observe(this){
            adapter.updateCard(it)
        }
        viewModel.getTxtToast().observe(this){
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
    }

    fun setAdapter(){
        binding.rcvCards.adapter = adapter

        adapter.onItemLongClick = {
            var cardTemp = adapter.listaCard[it]
            viewModel.excluirCard(cardTemp)
            viewModel.getListaFromDB()
        }

        adapter.onItemClick = {
            var cardTemp = adapter.listaCard[it]
            var intent = Intent(this, CadastroActivity::class.java)
            intent.putExtra("idCard", cardTemp.id)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        viewModel.getListaFromDB()
    }
}