package fr.everydaysapps.marvelsuperheroes.data

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("name") val name: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("realName") val realName: String,
    @SerializedName("height") val height: String,
    @SerializedName("power") val power: String,
    @SerializedName("abilities") val abilities: String,
    @SerializedName("groups") val groups: String
)
