package com.example.multipleapps.splashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.multipleapps.menu.MenuInicio
import com.example.multipleapps.databinding.ActivityMainBinding
import com.example.multipleapps.login.LoginActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        screenSplash.setKeepOnScreenCondition{true}
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()


    }
}