package com.example.multipleapps.timePicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityTimePickerBinding

class TimePicker : AppCompatActivity() {
    private lateinit var binding:ActivityTimePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTimePickerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etTime.setOnClickListener { showTimePickerDialog() }
    }

    private fun showTimePickerDialog() {
        val timePicker = TimePickerFragment{onTimeSelected(it)}
        timePicker.show(supportFragmentManager, "time")

    }
    private fun onTimeSelected(time:String){
        binding.etTime.setText("Has Seleccionado las $time Hrs")
    }
}