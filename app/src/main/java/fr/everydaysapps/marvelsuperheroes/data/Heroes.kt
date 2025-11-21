package fr.everydaysapps.marvelsuperheroes.data

import com.google.gson.annotations.SerializedName

data class Heroes(
    @SerializedName("superheroes") val elements: List<Hero>
)
