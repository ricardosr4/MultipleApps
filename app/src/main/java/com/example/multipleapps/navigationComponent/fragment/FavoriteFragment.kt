package com.example.multipleapps.navigationComponent.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.multipleapps.R
import com.example.multipleapps.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.tvFavorite.text = "Benvenido a Favoritos"
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

}