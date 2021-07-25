package com.app.calculanotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.calculanotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.buttonCalculate.setOnClickListener {
            with(binding) {
                val nota1 = Integer.parseInt(nota1.text.toString())
                val nota2 = Integer.parseInt(nota2.text.toString())
                val nota3 = Integer.parseInt(nota3.text.toString())
                val nota4 = Integer.parseInt(nota4.text.toString())
                val absences = Integer.parseInt(editOfAbsences.text.toString())
                val media = (nota1 + nota2 + nota3 + nota4) / 4
                val message = messageAlert

                if (media >= 5 && absences <= 20) {
                    message.setTextColor(resources.getColor(R.color.green))
                    message.text = "Aluno aprovado \n Média final ${media}"
                } else if (absences > 20) {
                    message.setTextColor(resources.getColor(R.color.red))
                    message.text = "Aluno Reprovado por faltas \n Faltas ${absences} \n Média final ${media}"
                } else if (media < 5) {
                    message.setTextColor(resources.getColor(R.color.red))
                    message.text = "Aluno Reprovado \n Média final ${media}"
                }
            }
        }
    }
}