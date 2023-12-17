package com.example.multipleapps.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityLoginBinding
import com.example.multipleapps.dogsApp.DogsApp
import com.example.multipleapps.menu.MenuInicio

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnEnter.setOnClickListener { navigateToMenu() }
        binding.tvCreateUser.setOnClickListener { navigateToLoginRegister() }

    }
    private fun navigateToMenu(){
        val intent = Intent(this, MenuInicio::class.java)
        startActivity(intent)
    }
    //todo funcion para navegar a login register
    private fun navigateToLoginRegister(){
        val intent = Intent(this, LoginRegisterActivity::class.java)
        startActivity(intent)
    }

}