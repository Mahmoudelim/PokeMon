package com.example.pokeman.data.remote

import androidx.compose.ui.geometry.Offset
import com.example.pokeman.data.remote.response.pokemon
import com.example.pokeman.data.remote.response.pokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {
@GET("pokemon")
suspend fun getPokemonList(
      @Query("limit") limit:Int ,
      @Query("offset") offset: Int
   ): pokemonList

@GET("pokemon/{name}")
suspend fun getPokemonInfo(
@Path("name") name: String
):pokemon
}