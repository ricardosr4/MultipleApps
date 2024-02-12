package com.example.multipleapps.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private var operation: Int = 0    // Variable para almacenar el tipo de operación (+, -, *, /)
    private var numero1: Double = 0.0   // Variable para almacenar el primer número en la operación

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val btnborrar: Button = binding.btnReset
        val btnigual: Button = binding.btnResultado

        btnigual.setOnClickListener {
            val numero2: Double = binding.tvNumberTwo.text.toString().toDouble()
            var response = 0.0
// Realiza la operación correspondiente según el valor de 'operation'
            when (operation) {
                1 -> {
                    response = numero1 + numero2
                }

                2 -> {
                    response = numero1 - numero2
                }

                3 -> {
                    response = numero1 * numero2
                }

                4 -> {
                    response = numero1 / numero2
                }
            }

            // Eliminar ceros innecesarios al final del número y muestra el resultado
            val resultadoSinCeros = response.toString().trimEnd('0').trimEnd('.')

            binding.tvNumberTwo.text = resultadoSinCeros
            binding.tvNumberOne.text = ""
        }
// Limpia los campos y reinicia las variables
        btnborrar.setOnClickListener {
            binding.tvNumberOne.text = ""
            binding.tvNumberTwo.text = ""
            numero1 = 0.0
            operation = 0
        }
    }

    fun presionarDigito(view: View) {
        val num2: String = binding.tvNumberTwo.text.toString()
// Limpia los campos y reinicia las variables
        when (view.id) {
            R.id.btn0 -> binding.tvNumberTwo.text = num2 + "0"
            R.id.btn1 -> binding.tvNumberTwo.text = num2 + "1"
            R.id.btn2 -> binding.tvNumberTwo.text = num2 + "2"
            R.id.btn3 -> binding.tvNumberTwo.text = num2 + "3"
            R.id.btn4 -> binding.tvNumberTwo.text = num2 + "4"
            R.id.btn5 -> binding.tvNumberTwo.text = num2 + "5"
            R.id.btn6 -> binding.tvNumberTwo.text = num2 + "6"
            R.id.btn7 -> binding.tvNumberTwo.text = num2 + "7"
            R.id.btn8 -> binding.tvNumberTwo.text = num2 + "8"
            R.id.btn9 -> binding.tvNumberTwo.text = num2 + "9"
            R.id.btnPunto -> binding.tvNumberTwo.text = num2 + "."
        }
    }

    fun clicOperacion(view: View) {
        numero1 = binding.tvNumberTwo.text.toString().toDouble()
        val num2Text: String = binding.tvNumberTwo.text.toString()
        binding.tvNumberTwo.text = ""
        // Actualiza la pantalla con la operación seleccionada y el número actual
        when (view.id) {
            R.id.btnSumar -> {
                binding.tvNumberOne.text = num2Text + "+"
                operation = 1
            }

            R.id.btnRestar -> {
                binding.tvNumberOne.text = num2Text + "-"
                operation = 2
            }

            R.id.btnMultiplicar -> {
                binding.tvNumberOne.text = num2Text + "*"
                operation = 3
            }

            R.id.btnDividir -> {
                binding.tvNumberOne.text = num2Text + "/"
                operation = 4
            }
        }
    }
}