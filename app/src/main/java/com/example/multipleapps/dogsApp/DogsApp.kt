package com.example.multipleapps.dogsApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multipleapps.R
import com.example.multipleapps.databinding.ActivityDogsAppBinding
import com.example.multipleapps.dogsApp.core.RetrofitDogs
import com.example.multipleapps.dogsApp.data.model.DogsResponse
import com.example.multipleapps.dogsApp.data.network.ApiDogs
import com.example.multipleapps.dogsApp.ui.adapter.DogAdapter
import com.google.android.material.internal.ViewUtils.hideKeyboard
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.create

class DogsApp : AppCompatActivity(), OnQueryTextListener {
    private lateinit var binding: ActivityDogsAppBinding
    private lateinit var adapter: DogAdapter
    private val dogImage = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsAppBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImage)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter

    }


    //todo esta funcion es para buscar en el searchView por raza de perro
    private fun searchByName(query: String) {
        //todo aqui una coroutine, todo lo que este aqui se muestra en un hilo secundario
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<DogsResponse> =
                RetrofitDogs.getRetrofit().create(ApiDogs::class.java)
                    .getDogsBYBreeds("$query/images")
            val puppies: DogsResponse? = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    val images: List<String> = puppies?.images ?: emptyList()
                    dogImage.clear()
                    dogImage.addAll(images)
                    adapter.notifyDataSetChanged()
                    //si esta correcto muestra el reciclerView
                } else {
                    showError()
                }
                hideKeyboard()


            }
        }

    }
    //Todo esta funcion sirve para esconder el teclado al presionar enter
    fun hideKeyboard(){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.viewRoot.windowToken, 0)

    }
    //todo esta funcion es para mostrar un mensaje de error a traves de un toast
    fun showError(){
        Toast.makeText(this, "Ha Ocurrido un Error", Toast.LENGTH_SHORT).show()
    }
//Todo se implementan estos 2 mtodos onQuery para usar el searcView
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchByName(query.toLowerCase())
        }
    return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
      return true
    }
}