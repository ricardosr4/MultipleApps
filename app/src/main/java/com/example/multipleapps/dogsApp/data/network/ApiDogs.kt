package com.example.multipleapps.dogsApp.data.network

import com.example.multipleapps.dogsApp.data.model.DogsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiDogs {
    //todo aqui se crea el metodo para hacer el consumo a nuestra api o a nuestro servicio
    @GET
    suspend fun getDogsBYBreeds(@Url url:String): Response<DogsResponse>


}