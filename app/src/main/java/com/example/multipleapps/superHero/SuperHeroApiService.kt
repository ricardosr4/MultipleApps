package com.example.multipleapps.superHero

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SuperHeroApiService {
//todo en la linea 8 {name} colocaremos en nombre que queramos buscar, es por eso que se agrega el @Path
    @GET("api/122112401630139554/search/{name}")
    suspend fun getSuperHero(@Path ("name") superHeroName:String) :Response<SuperHeroDataResponse>
}