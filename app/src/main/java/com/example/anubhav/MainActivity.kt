package com.example.anubhav

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.anubhav.MainScreen.MainScreen
import com.example.anubhav.Projects.Calculator.CalcScreen
import com.example.anubhav.ui.theme.Def
import com.example.anubhav.ui.theme.IntroPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController, "mainActivity") {
                composable("mainActivity") {
                    MainScreen(navController)
                }
                composable("introPage/{tag}") {
                    val tag = it.arguments?.getString("tag") ?: "def"

                    IntroPage(tag, navController)

                }
                composable("calc") {
                    val tag = it.arguments?.getString("tag") ?: "calc"
                    CalcScreen()
                }
                composable("notes") {
                    Def()
                }
            }

        }
    }
}

