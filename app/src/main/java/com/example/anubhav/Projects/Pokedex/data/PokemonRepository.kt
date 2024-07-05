package com.example.anubhav.Projects.Pokedex.data

import com.example.anubhav.Projects.Pokedex.data.model.Pokemon
import com.example.anubhav.Projects.Pokedex.data.model.Result
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Flow<Response<List<Result>>>
    suspend fun getPokemonDetail(name: String): Flow<Response<Pokemon>>
}