package fr.everydaysapps.marvelsuperheroes.ui.heroes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HeroDetailScreen(viewModel: HeroDetailViewModel = hiltViewModel()) {
    val hero = viewModel.hero.collectAsState().value

    hero?.let {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GlideImage(
                model = it.photo,
                contentDescription = it.name,
                modifier = Modifier.size(200.dp)
            )
            Text(text = it.name, style = MaterialTheme.typography.h4)
            Text(text = "Real Name: ${it.realName}")
            Text(text = "Height: ${it.height}")
            Text(text = "Power: ${it.power}")
            Text(text = "Abilities: ${it.abilities}")
            Text(text = "Groups: ${it.groups}")
        }
    }
}
