package com.example.jokenpotbbt

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val botaoSpock = findViewById<ImageButton>(R.id.botaoSpock)
        val botaoLagarto = findViewById<ImageButton>(R.id.lagarto)
        val botaoPedra = findViewById<ImageButton>(R.id.pedra)
        val botaoPapel = findViewById<ImageButton>(R.id.papel)
        val botaoTesoura = findViewById<ImageButton>(R.id.tesoura)
        val textoResultado = findViewById<TextView>(R.id.textoResultado)
        val resultadoMaquina = findViewById<ImageView>(R.id.resultadoMaquina)
        val resultadoUsuario = findViewById<ImageView>(R.id.resultadoUsuario)

        fun opcoesMaquina() {
            val opcoes = arrayOf("spock", "lagarto", "pedra", "papel", "tesoura")
            val escolhaMaquina = opcoes[Random.nextInt(opcoes.size)]

            when (escolhaMaquina) {
                "spock" -> resultadoMaquina.setImageResource(R.drawable.spock)
                "lagarto" -> resultadoMaquina.setImageResource(R.drawable.lagarto)
                "pedra" -> resultadoMaquina.setImageResource(R.drawable.pedra)
                "papel" -> resultadoMaquina.setImageResource(R.drawable.papel)
                "tesoura" -> resultadoMaquina.setImageResource(R.drawable.tesoura)
            }


            when (resultadoUsuario.tag) {
                "spock" -> when (escolhaMaquina) {
                    "tesoura", "pedra" -> textoResultado.text = "Você ganhou! 🤩"
                    "lagarto", "papel" -> textoResultado.text = "Você perdeu 😢"
                    "spock" -> textoResultado.text = "Empatou! 🤣"
                }
                "lagarto" -> when (escolhaMaquina) {
                    "spock", "papel" -> textoResultado.text = "Você ganhou! 🤩"
                    "tesoura", "pedra" -> textoResultado.text = "Você perdeu 😢"
                    "lagarto" -> textoResultado.text = "Empatou! 🤣"
                }
                "pedra" -> when (escolhaMaquina) {
                    "lagarto", "tesoura" -> textoResultado.text = "Você ganhou! 🤩"
                    "papel", "spock" -> textoResultado.text = "Você perdeu 😢"
                    "pedra" -> textoResultado.text = "Empatou! 🤣"
                }
                "papel" -> when (escolhaMaquina) {
                    "pedra", "spock" -> textoResultado.text = "Você ganhou! 🤩"
                    "tesoura", "lagarto" -> textoResultado.text = "Você perdeu 😢"
                    "papel" -> textoResultado.text = "Empatou! 🤣"
                }
                "tesoura" -> when (escolhaMaquina) {
                    "papel", "lagarto" -> textoResultado.text = "Você ganhou! 🤩"
                    "spock", "pedra" -> textoResultado.text = "Você perdeu 😢"
                    "tesoura" -> textoResultado.text = "Empatou! 🤣"
                }
            }
        }

        botaoSpock.setOnClickListener {
            resultadoUsuario.setImageResource(R.drawable.spock)
            resultadoUsuario.tag = "spock"
            opcoesMaquina()
        }

        botaoLagarto.setOnClickListener {
            resultadoUsuario.setImageResource(R.drawable.lagarto)
            resultadoUsuario.tag = "lagarto"
            opcoesMaquina()
        }

        botaoPedra.setOnClickListener {
            resultadoUsuario.setImageResource(R.drawable.pedra)
            resultadoUsuario.tag = "pedra"
            opcoesMaquina()
        }

        botaoPapel.setOnClickListener {
            resultadoUsuario.setImageResource(R.drawable.papel)
            resultadoUsuario.tag = "papel"
            opcoesMaquina()
        }

        botaoTesoura.setOnClickListener {
            resultadoUsuario.setImageResource(R.drawable.tesoura)
            resultadoUsuario.tag = "tesoura"
            opcoesMaquina()
        }

    }
}