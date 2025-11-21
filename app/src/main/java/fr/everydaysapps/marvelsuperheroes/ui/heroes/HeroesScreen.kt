package fr.everydaysapps.marvelsuperheroes.ui.heroes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HeroesScreen(
    viewModel: HeroesViewModel = hiltViewModel(),
    onHeroClick: (fr.everydaysapps.marvelsuperheroes.data.Hero) -> Unit
) {
    val heroes = viewModel.heroes.collectAsState().value
    val isLoading = viewModel.isLoading.collectAsState().value

    Box(modifier = Modifier.fillMaxSize()) {
        if (isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            HeroesList(heroes = heroes, onItemClick = onHeroClick)
        }
    }
}
