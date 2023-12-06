package com.example.multipleapps.saludo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

//todo aqui se muestra el nombre escrito con un EXTRA NAME en la pantalla result
        val name = intent.getStringExtra("EXTRA_NAME").orEmpty()
        binding.tvGreeting.text = "Hola, $name"

    }
}