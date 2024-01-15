package com.example.multipleapps.superHero

import com.google.gson.annotations.SerializedName

data class SuperHeroDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("results") val superheroes: List<SuperHeroItemResponse>

)
data class SuperHeroItemResponse(
    @SerializedName("id") val superheroId: String,
    @SerializedName("name") val name: String,
    @SerializedName("image") val SuperHeroImage: SuperHeroImageResponse

)
data class SuperHeroImageResponse(
    @SerializedName("url") val url: String
)