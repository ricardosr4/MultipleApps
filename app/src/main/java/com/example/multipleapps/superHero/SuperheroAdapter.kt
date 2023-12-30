package com.example.multipleapps.superHero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.multipleapps.R

//todo Aqui se crea el Adapter y se implementan 3 metodos
class SuperheroAdapter(private var superheroList: List<SuperHeroItemResponse> = emptyList()) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {

    fun updateList(list: List<SuperHeroItemResponse>){
        this.superheroList = list
        notifyDataSetChanged()

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        return SuperHeroViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_recyclerview_superhero, parent, false)
            )
    }

    override fun onBindViewHolder(viewHolder: SuperHeroViewHolder, position: Int) {
        viewHolder.bind(superheroList[position])
    }

    override fun getItemCount() = superheroList.size


}