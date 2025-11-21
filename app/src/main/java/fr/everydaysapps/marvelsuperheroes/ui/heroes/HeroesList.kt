package fr.everydaysapps.marvelsuperheroes.ui.heroes

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import fr.everydaysapps.marvelsuperheroes.data.Hero

@Composable
fun HeroesList(heroes: List<Hero>, onItemClick: (Hero) -> Unit) {
    LazyColumn {
        items(heroes) { hero ->
            HeroesListItem(hero = hero, onItemClick = onItemClick)
        }
    }
}
