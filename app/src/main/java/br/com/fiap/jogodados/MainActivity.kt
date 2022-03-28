package br.com.fiap.jogodados

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jogarDados()
    }

    fun jogarDados(){
        var dices = arrayOf(R.drawable.dado_1,
                            R.drawable.dado_2,
                            R.drawable.dado_3,
                            R.drawable.dado_4,
                            R.drawable.dado_5,
                            R.drawable.dado_6)

        btnJogar.setOnClickListener {
            var ladosDados = arrayListOf(1,2,3,4,5,6)
            var resultado1 = ladosDados[Random.nextInt(0, 5)]
            var resultado2 = ladosDados[Random.nextInt(0, 5)]

            var imageView1 = findViewById<ImageView>(R.id.imgDadoJogador1)
            var imageView2 = findViewById<ImageView>(R.id.imgDadoJogador2)

            imageView1.setImageResource(dices[resultado1])
            imageView2.setImageResource(dices[resultado2])

            var vencedor = when {
                resultado1 > resultado2 -> "Vencedor 1 Ganhou com ${resultado1 + 1}"
                resultado1 < resultado2 -> "Vencedor 2 Ganhou com ${resultado2 + 1}"
                else -> "Empate"
            }

            Toast.makeText(this, vencedor, Toast.LENGTH_SHORT).show()
        }
    }
}