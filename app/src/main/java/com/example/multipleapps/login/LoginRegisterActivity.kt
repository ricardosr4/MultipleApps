package com.example.multipleapps.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityLoginRegisterBinding
import com.example.multipleapps.menu.MenuInicio

class LoginRegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvIrLogin.setOnClickListener { navigateToLogin() }
    }
//todo funcion para navegar a login
    private fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}