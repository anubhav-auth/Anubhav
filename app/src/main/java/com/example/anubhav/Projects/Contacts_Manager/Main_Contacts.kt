package com.example.anubhav.Projects.Contacts_Manager

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.example.anubhav.Projects.Contacts_Manager.presentation.ContactScreen
import com.example.anubhav.Projects.Contacts_Manager.presentation.ContactViewModel


@Composable
fun Main_Contacts(viewModel: ContactViewModel) {

    val state = viewModel.state.collectAsState()

    ContactScreen(state = state, event = viewModel::onEvent)
}