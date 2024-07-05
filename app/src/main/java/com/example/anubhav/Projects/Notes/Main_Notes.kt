package com.example.anubhav.Projects.Notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anubhav.Projects.Notes.presentation.AddNotesScreen
import com.example.anubhav.Projects.Notes.presentation.NotesScreen
import com.example.anubhav.Projects.Notes.presentation.notesViewModel


@Composable
fun Main_Notes(viewModel: notesViewModel){
    val navController = rememberNavController()
    val state by viewModel.state.collectAsState()

    NavHost(navController = navController, startDestination = "notes_screen" ) {
        composable("notes_screen"){
            NotesScreen(navController = navController, state = state, onEvent = viewModel::onEvent)
        }
        composable("add_notes_screen"){
            AddNotesScreen(navController = navController, state = state, onEvent = viewModel::onEvent)
        }
    }
}