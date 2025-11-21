package fr.everydaysapps.marvelsuperheroes.ui.heroes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import fr.everydaysapps.marvelsuperheroes.data.Hero
import fr.everydaysapps.marvelsuperheroes.data.HeroesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel @Inject constructor(
    private val repository: HeroesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _hero = MutableStateFlow<Hero?>(null)
    val hero: StateFlow<Hero?> = _hero

    init {
        savedStateHandle.get<String>("heroName")?.let { heroName ->
            viewModelScope.launch {
                _hero.value = repository.getHeroByName(heroName)
            }
        }
    }
}
