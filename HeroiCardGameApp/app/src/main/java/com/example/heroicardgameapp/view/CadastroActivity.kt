package com.example.heroicardgameapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.heroicardgameapp.R
import com.example.heroicardgameapp.databinding.ActivityCadastroBinding
import com.example.heroicardgameapp.services.model.CardGame
import com.example.heroicardgameapp.viewmodel.CadastroViewModel

class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var cadastroViewModel: CadastroViewModel
    private lateinit var cardFromDB: CardGame
    private var idCard: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cadastroViewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        setObservers()

        idCard = intent.getIntExtra("idCard", idCard)

        if (idCard > 0) {
            cadastroViewModel.findCard(idCard)
            binding.txtTitulo.text = "Editar Herói!"
        }

        binding.btnSalvar.setOnClickListener {
            var nomeHeroi = binding.edtNomeHeroi.text.toString()
            var ataqueHeroi = binding.edtAtaqueHeroi.text.toString()
            var defesaHeroi = binding.edtDefesaHeroi.text.toString()

            if (idCard > 0) {
                cardFromDB.nome = nomeHeroi
                cardFromDB.ataque = ataqueHeroi.toInt()
                cardFromDB.defesa = defesaHeroi.toInt()

                if (cadastroViewModel.atualizarCard(cardFromDB)) {
                    finish()
                }

            } else if (cadastroViewModel.salvarTarefa(nomeHeroi, ataqueHeroi, defesaHeroi)) {
                finish()
            }
        }
    }

    fun setObservers() {
        cadastroViewModel.getTxtToast().observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        cadastroViewModel.getCardFromDB().observe(this) {
            cardFromDB = it
            binding.edtNomeHeroi.setText(cardFromDB.nome)
            binding.edtAtaqueHeroi.setText(cardFromDB.ataque)
            binding.edtDefesaHeroi.setText(cardFromDB.defesa)
        }
    }
}