package com.example.multipleapps.superHero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleapps.databinding.ItemRecyclerviewSuperheroBinding
import com.example.multipleapps.superHero.data.model.SuperHeroItemResponse
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view){

//todo Aqui inicializamos nuestro binding en nuestro viewHolder
    private val binding = ItemRecyclerviewSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperHeroName.text = superHeroItemResponse.name
        //aqui se llama la libreria picasso y luego se carga la url de la imagen
        Picasso.get().load(superHeroItemResponse.SuperHeroImage.url).into(binding.ivSuperHero)
        binding.root.setOnClickListener { onItemSelected(superHeroItemResponse.superheroId) }

    }
}