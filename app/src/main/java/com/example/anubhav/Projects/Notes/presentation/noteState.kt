package com.example.anubhav.Projects.Notes.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.anubhav.Projects.Notes.data.Notes

data class noteState (

    val notes: List<Notes> = emptyList(),
    val title: MutableState<String> = mutableStateOf(""),
    val body: MutableState<String> = mutableStateOf("")

    )