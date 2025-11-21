package fr.everydaysapps.marvelsuperheroes.ui.heroes

import android.util.Log
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
class HeroesViewModel @Inject constructor(private val repository: HeroesRepository) : ViewModel() {

    private val _heroes = MutableStateFlow<List<Hero>>(emptyList())
    val heroes: StateFlow<List<Hero>> = _heroes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        getHeroes()
    }

    private fun getHeroes() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val heroes = repository.getHeroes()
                _heroes.value = heroes.elements
            } catch (e: Exception) {
                Log.e("HeroesViewModel", "Error getting heroes", e)
            } finally {
                _isLoading.value = false
            }
        }
    }
}
