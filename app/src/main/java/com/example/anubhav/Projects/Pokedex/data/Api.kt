package com.example.anubhav.Projects.Pokedex.data

import com.example.anubhav.Projects.Pokedex.data.model.Pokemon
import com.example.anubhav.Projects.Pokedex.data.model.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface Api {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ): Pokemon

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2/"
    }
}