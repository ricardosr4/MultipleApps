package com.example.multipleapps.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.calculator.Calculator
import com.example.multipleapps.courseKotlin.CourseKotlin
import com.example.multipleapps.databinding.ActivityMenuInicioBinding
import com.example.multipleapps.datePicker.DatePicker
import com.example.multipleapps.dogsApp.DogsApp
import com.example.multipleapps.navigationComponent.NavigationComponent
import com.example.multipleapps.saludo.Saludo
import com.example.multipleapps.superHero.ui.activity.SuperHeroActivity
import com.example.multipleapps.timePicker.TimePicker

class MenuInicio : AppCompatActivity() {
    private lateinit var binding: ActivityMenuInicioBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuInicioBinding.inflate(layoutInflater)
        setContentView(binding.root)
//todo aqui al presionar el boton se llama a la funcion
        binding.btnSaludarApp.setOnClickListener { navigateToSaludarApp() }
        binding.btnDatePicker.setOnClickListener { navigateToDatePicker() }
        binding.btnTimePicker.setOnClickListener { navigateToTimePicker() }
        binding.btnNavigationComponent.setOnClickListener { navigateToNavigationComponent() }
        binding.btnCourseKotlin.setOnClickListener { navigateToCourseKotlin() }
        binding.btnCalculator.setOnClickListener { navigateToCalculator() }
        binding.btnDogsApp.setOnClickListener { navigateToDogsApp() }
        binding.btnSuperHero.setOnClickListener { navigateToSuperHero() }


    }



    //todo Aqui se crean las funciones para navegar a traves de un intent hacia la pantalla seleccionada
    private fun navigateToSaludarApp() {
        val intent = Intent(this, Saludo::class.java)
        startActivity(intent)
    }
    private fun navigateToDatePicker() {
        val intent = Intent(this, DatePicker::class.java)
        startActivity(intent)
    }
    private fun navigateToTimePicker() {
        val intent = Intent(this, TimePicker::class.java)
        startActivity(intent)
    }
    private fun navigateToNavigationComponent() {
        val intent = Intent(this, NavigationComponent::class.java)
        startActivity(intent)
    }
    private fun navigateToCourseKotlin() {
        val intent = Intent(this, CourseKotlin::class.java)
        startActivity(intent)
    }
    private fun navigateToCalculator() {
        val intent = Intent(this, Calculator::class.java)
        startActivity(intent)
    }

    private fun navigateToDogsApp() {
        val intent = Intent(this, DogsApp::class.java)
        startActivity(intent)
    }
    private fun navigateToSuperHero() {
        val intent = Intent(this, SuperHeroActivity::class.java)
        startActivity(intent)
    }
}