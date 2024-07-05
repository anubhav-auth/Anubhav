package com.example.anubhav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.anubhav.MainScreen.MainScreen
import com.example.anubhav.Projects.Calculator.CalcScreen
import com.example.anubhav.Projects.Contacts_Manager.Main_Contacts
import com.example.anubhav.Projects.Notes.Main_Notes
import com.example.anubhav.Projects.Notes.data.noteDatabase
import com.example.anubhav.Projects.Notes.presentation.notesViewModel
import com.example.anubhav.Projects.Pokedex.Main_Poke
import com.example.anubhav.Projects.Pokedex.data.PokemonRepositoryImpl
import com.example.anubhav.Projects.Pokedex.data.RetrofitInstance
import com.example.anubhav.Projects.Pokedex.presentation.PokemonDetailViewModel
import com.example.anubhav.Projects.Pokedex.presentation.PokemonViewModel
import com.example.anubhav.ui.Project
import com.example.anubhav.ui.theme.Def
import com.example.anubhav.ui.IntroPage
import com.example.anubhav.Projects.Contacts_Manager.data.ContactsDatabase
import com.example.anubhav.Projects.Contacts_Manager.presentation.ContactViewModel

class MainActivity : ComponentActivity() {

    private val pokemonListViewmodel by viewModels<PokemonViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PokemonViewModel(PokemonRepositoryImpl(RetrofitInstance.api)) as T
            }
        }
    })

    private val detailViewModel by viewModels<PokemonDetailViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return PokemonDetailViewModel(PokemonRepositoryImpl(RetrofitInstance.api)) as T
            }
        }
    })

    private val noteDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            noteDatabase::class.java,
            "notes.db"
        ).build()
    }

    private val notesViewModel by viewModels<notesViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return notesViewModel(noteDatabase.dao) as T
                }
            }
        }
    )

    private val contactsDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            ContactsDatabase::class.java,
            "contacts.db"
        ).build()
    }

    private val contactViewModel by viewModels<ContactViewModel> (
        factoryProducer = {
            object : ViewModelProvider.Factory{
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return ContactViewModel(contactsDatabase.dao) as T
                }
            }
        }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val navController = rememberNavController()


//            when adding new apps add the list entry here and make a composable in navhost
//            if the app code is not added then navigate to def() in the composable
            val mainList = listOf(
                Project(
                    "poke",
                    "POKEDEX",
                    context.resources.getString(R.string.pokedex_intro),
                    R.drawable.poke1,
                    R.drawable.poke2,
                    listOf("KOTLIN", "JETPACK COMPOSE", "RETROFIT", "COIL", "POKÉ-API"),
                    navController
                ),
                Project(
                    "calc",
                    "Calculator",
                    context.resources.getString(R.string.calc_intro),
                    R.drawable.calc1,
                    R.drawable.calc2,
                    listOf("KOTLIN", "JETPACK COMPOSE", "MXPARSER", "ANDROID"),
                    navController
                ),
                Project(
                    "notes",
                    "NOTES",
                    context.resources.getString(R.string.notes_intro),
                    R.drawable.notes1,
                    R.drawable.notes2,
                    listOf("KOTLIN", "JETPACK COMPOSE", "ROOM"),
                    navController
                ),
                Project(
                    "cont",
                    "CONTACTS",
                    context.resources.getString(R.string.contacts_intro),
                    R.drawable.cont1,
                    R.drawable.cont2,
                    listOf("KOTLIN", "JETPACK COMPOSE", "ROOM"),
                    navController
                )

            )


            Scaffold{ paddingValues ->
                val pad = paddingValues
                Box (modifier = Modifier.fillMaxSize()){
                    NavHost(navController, "mainActivity") {
                        composable("mainActivity") {
                            MainScreen(mainList,navController, context)
                        }
                        composable("introPage/{tag}") {
                            val tag = it.arguments?.getString("tag") ?: "def"
                            IntroPage(mainList,tag, navController)
                        }
                        composable("calc") {
                            CalcScreen()
                        }
                        composable("notes") {
                            Main_Notes(viewModel = notesViewModel)
                        }
                        composable("cont") {
                            Main_Contacts(viewModel = contactViewModel)
                        }
                        composable("poke") {
                            Main_Poke(pokemonListViewmodel = pokemonListViewmodel, detailViewModel = detailViewModel , context = context)
                        }
                    }
                }
            }


        }

    }


}

