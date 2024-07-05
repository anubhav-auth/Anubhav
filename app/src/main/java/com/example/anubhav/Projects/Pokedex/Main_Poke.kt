package com.example.anubhav.Projects.Pokedex

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import com.example.anubhav.Projects.Pokedex.presentation.DetailScreen
import com.example.anubhav.Projects.Pokedex.presentation.HomeScreen
import com.example.anubhav.Projects.Pokedex.presentation.PokemonDetailViewModel
import com.example.anubhav.Projects.Pokedex.presentation.PokemonViewModel
import com.example.anubhav.ui.theme.backGrad1
import com.example.anubhav.ui.theme.backGrad2

@Composable
fun Main_Poke(pokemonListViewmodel: PokemonViewModel, detailViewModel: PokemonDetailViewModel,context: Context) {
    val navController = rememberNavController()
    val imageLoader = ImageLoader.Builder(context).crossfade(true).build()
    Scaffold { padd ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backGrad2)
                .padding(paddingValues = padd)
        ) {

            NavHost(
                navController = navController, startDestination = "pokemon_listScreen"
            ) {
                composable("pokemon_listScreen") {
                    HomeScreen(
                        viewmodel = pokemonListViewmodel, navController = navController
                    )
                }
                composable("Pokemon_detailScreen/{name}/{dominantColor}") {
                    val pokemonName = it.arguments?.getString("name") ?: "ditto"
                    val dominantColor =
                        it.arguments?.getString("dominantColor")?.toIntOrNull()
                            ?.let { Color(it) } ?: Color.Blue
                    DetailScreen(
                        pokemonName = pokemonName,
                        viewmodel = detailViewModel,
                        imageLoader = imageLoader,
                        navController = navController,
                        dominantColor = dominantColor
                    )
                }
            }
        }
    }
}