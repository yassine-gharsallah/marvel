package fr.everydaysapps.marvelsuperheroes.data

import fr.everydaysapps.marvelsuperheroes.api.HeroApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroesRepository @Inject constructor(private val api: HeroApi) {

    private var heroes: Heroes? = null

    suspend fun getHeroes(): Heroes {
        if (heroes == null) {
            heroes = api.getHeroes()
        }
        return heroes!!
    }

    suspend fun getHeroByName(name: String): Hero? {
        if (heroes == null) {
            getHeroes()
        }
        return heroes?.elements?.firstOrNull { it.name == name }
    }
}
