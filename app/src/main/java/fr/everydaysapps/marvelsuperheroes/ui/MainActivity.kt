package fr.everydaysapps.marvelsuperheroes.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import fr.everydaysapps.marvelsuperheroes.ui.theme.MarvelSuperHeroesTheme

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelSuperHeroesTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController)
            }
        }
    }
}
