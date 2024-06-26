package com.example.anubhav

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel

class SharedStateViewModel: ViewModel() {
    //calc
    var swapState by mutableStateOf(true)
    var angleUnitState by mutableStateOf(true)
    var sizeState by mutableStateOf(460.dp)
    var ButtonScale by mutableStateOf(0f)
    var inverseState by mutableStateOf(true)
    var element by mutableStateOf("")
    var answer by mutableStateOf("")
    var equalClicked by mutableStateOf(false)
    var ansButt by mutableStateOf("")
    var equalAnsStore by mutableStateOf("")

    //mainScreen
    var selectedItemIndex by mutableStateOf(0)
}