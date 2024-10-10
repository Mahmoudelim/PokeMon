package com.example.pokeman.DetailScreen

import androidx.lifecycle.ViewModel
import com.example.pokeman.data.remote.response.pokemon
import com.example.pokeman.repository.pokemonRepository
import com.example.pokeman.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
   private val repository: pokemonRepository


): ViewModel(){

  suspend fun getPokemonInfo(pokemonName: String) :Resource<pokemon> {
      return repository.getPokemonInfo(pokemonName)
  }

}