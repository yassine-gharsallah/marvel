package fr.everydaysapps.marvelsuperheroes.api

import fr.everydaysapps.marvelsuperheroes.data.Heroes
import retrofit2.http.GET

interface HeroApi {

    @GET("test-mobile/iOS/json/test2.json")
    suspend fun getHeroes(): Heroes
}
