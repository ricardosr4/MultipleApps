package com.example.multipleapps.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
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

    private fun navigateToMenu() {
        // aqui dice que si el correo es valido puede entrar
        val email = binding.etUser.text.toString()
        if (isValidEmail(email)) {

            val intent = Intent(this, MenuInicio::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Coreo electronico no valido", Toast.LENGTH_SHORT).show()
        }
    }

    //todo funcion para navegar a login register
    private fun navigateToLoginRegister() {
        val intent = Intent(this, LoginRegisterActivity::class.java)
        startActivity(intent)
    }

//todo esta funcion es para validar que sea un correo valido que se esta ingresando
    private fun isValidEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()

    }
}