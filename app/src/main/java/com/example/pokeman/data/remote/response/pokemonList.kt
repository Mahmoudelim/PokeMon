package com.example.pokeman.data.remote.response

data class pokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)