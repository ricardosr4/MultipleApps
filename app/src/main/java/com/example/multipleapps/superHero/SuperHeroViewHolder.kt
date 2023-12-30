package com.example.multipleapps.superHero

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleapps.databinding.ItemRecyclerviewSuperheroBinding

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view){

//todo Aqui inicializamos nuestro binding en nuestro viewHolder
    private val binding = ItemRecyclerviewSuperheroBinding.bind(view)

    fun bind(superHeroItemResponse: SuperHeroItemResponse){
        binding.tvSuperHeroName.text = superHeroItemResponse.name

    }
}