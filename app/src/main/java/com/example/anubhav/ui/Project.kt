package com.example.anubhav.ui

import androidx.navigation.NavController

data class Project(
    val tag: String,
    val title: String,
    val description: String,
    val imgId1: Int,
    val imgId2: Int,
    val stack: List<String>,
    val navController: NavController
)