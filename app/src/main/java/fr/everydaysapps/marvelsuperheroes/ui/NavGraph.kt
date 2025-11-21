package fr.everydaysapps.marvelsuperheroes.ui

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.everydaysapps.marvelsuperheroes.ui.heroes.HeroDetailScreen
import fr.everydaysapps.marvelsuperheroes.ui.heroes.HeroesScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "heroes"
    ) {
        composable("heroes") {
            HeroesScreen(
                onHeroClick = { hero ->
                    navController.navigate("heroDetail/${hero.name}")
                }
            )
        }
        composable("heroDetail/{heroName}") {
            HeroDetailScreen(viewModel = hiltViewModel())
        }
    }
}
