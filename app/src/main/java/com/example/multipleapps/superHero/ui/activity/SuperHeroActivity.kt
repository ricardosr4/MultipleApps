package com.example.multipleapps.superHero.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleapps.databinding.ActivitySuperHeroBinding
import com.example.multipleapps.superHero.ui.adapter.SuperheroAdapter
import com.example.multipleapps.superHero.ui.activity.DetailSuperheroActivity.Companion.EXTRA_ID
import com.example.multipleapps.superHero.data.model.SuperHeroDataResponse
import com.example.multipleapps.superHero.data.network.SuperHeroApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySuperHeroBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getRetrofit()
        initUi()
    }

    //todo aqui se implementan 2 metodos de object (onQuery), esto es para hacer funcionar el searchView
    private fun initUi() {
        binding.svSuperHero.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        }
        )
        //todo dentro en nuestro initUi() crearemos nuestro Adapter
        adapter = SuperheroAdapter{navigateToItemSuperHero(it)}
        binding.rvSuperHero.setHasFixedSize(true)
        binding.rvSuperHero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperHero.adapter = adapter
    }

    //todo en esta corrutina se crea el hilo secundario para hacer la llamada a la api
    private fun searchByName(query: String) {
        binding.progressBar.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val myResponse = retrofit.create(SuperHeroApiService::class.java).getSuperHero(query)
            if (myResponse.isSuccessful) {
                Log.i("ricardo", "funciona")
                val response: SuperHeroDataResponse? = myResponse.body()
                if (response != null) {
                    Log.i("ricardo", response.toString())
                    runOnUiThread {
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible = false
                    }
                }
            } else {
                Log.i("ricardo", "no funciona")
            }
        }
    }

    //todo Aqui se crea un objeto Retrofit
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    private fun navigateToItemSuperHero(id:String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID,id)
        startActivity(intent)


    }
}