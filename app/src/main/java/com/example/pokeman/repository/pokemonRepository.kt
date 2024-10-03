package com.example.pokeman.repository

import com.example.pokeman.data.remote.PokeApi
import com.example.pokeman.data.remote.response.pokemon
import com.example.pokeman.data.remote.response.pokemonList
import com.example.pokeman.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class pokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int , offest:Int): Resource<pokemonList>
    {
      val response = try {
          api.getPokemonList(limit,offest)
      } catch (e:Exception){
        return Resource.Error("An unknown error occured")
      }
return Resource.Success(response)
    }


    suspend fun getPokemonInfo(pokemonName: String):Resource<pokemon>{
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e:Exception){
            return Resource.Error("An unknown error occured")
        }
        return Resource.Success(response)
    }


}