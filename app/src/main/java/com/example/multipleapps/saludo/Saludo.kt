package com.example.multipleapps.saludo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.databinding.ActivitySaludoBinding

class Saludo : AppCompatActivity() {
    private lateinit var binding: ActivitySaludoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySaludoBinding.inflate(layoutInflater)
        setContentView(binding.root)

//todo aqui se le da una funcion al boton star para pasar el texto a la sigiente activity
        binding.btnStar.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA_NAME", name)
                startActivity(intent)
            }
        }

    }
}