package com.example.multipleapps.dogsApp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleapps.R

class DogAdapter(val images: List<String>): RecyclerView.Adapter<DogViewHolder>() {
    //todo Aqui en nuestro adapter implementamos estos 3 metodos override
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        return DogViewHolder(layoutInflater.inflate(R.layout.item_dogs,parent,false))
    }

    override fun getItemCount(): Int = images.size



    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item: String = images[position]
        holder.bind(item)
    }
}