package com.example.multipleapps.navigationComponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityNavigationComponentBinding

class NavigationComponent : AppCompatActivity() {
    private lateinit var binding: ActivityNavigationComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationComponentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation()
    }

    private fun setupNavigation() {
        val bottomNavigationView = binding.bottomNavigationView
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            navHostFragment.navController
        )

    }

}
