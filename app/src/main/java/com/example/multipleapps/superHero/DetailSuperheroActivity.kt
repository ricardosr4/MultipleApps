package com.example.multipleapps.superHero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.multipleapps.R

class DetailSuperheroActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_ID = "extra_id"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_superhero)
    }
}