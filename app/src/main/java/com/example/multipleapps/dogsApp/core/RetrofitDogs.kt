package com.example.multipleapps.dogsApp.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitDogs {

    fun getRetrofit(): Retrofit{
        return Retrofit
            .Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}