package com.example.anubhav.Projects.Pokedex.data.model

data class PokemonList(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<Result>
)