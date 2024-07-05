package com.example.anubhav.Projects.Contacts_Manager.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anubhav.Projects.Contacts_Manager.data.Contacts

@Composable
fun ContactScreen(
    state: State<ContactState>, event: (ContactsEvents) -> Unit
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(containerColor = Color.Cyan, onClick = {
            event(ContactsEvents.showDialog)
        }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = "add contact")
        }
    }) {

        if (state.value.isAddingContact) {
            AddContactDialog(state = state.value, onEvent = event)
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(it)
        ) {
            var selectedState by remember { mutableStateOf("first name") }

            LazyRow(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                item {
                    Row {
                        SortType.values().forEach {
                            sortType ->
                            Row(
                                modifier = Modifier
                                    .clickable {
                                        event(ContactsEvents.sortContacts(sortType))
                                    },
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                RadioButton(
                                    selected = state.value.sortType == sortType,
                                    onClick = { event(ContactsEvents.sortContacts(sortType)) },
                                    colors = RadioButtonColors(selectedColor = Color.Blue, unselectedColor = Color.White, Color.Gray, Color.Gray)
                                )
                                Text(text = sortType.name, color = Color.White)
                            }
                        }
                    }
                }
            }

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.value.contacts) {
                    contactItems(contacts = it, onEvent = event)
                }
            }

        }
    }

}

@Composable
fun contactItems(contacts: Contacts, onEvent: (ContactsEvents) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = "${contacts.firstName} ${contacts.lastName}", fontSize = 24.sp, color = Color.White
            )
            Text(text = contacts.email, color = Color.White)
            Text(text = "+91 ${contacts.phoneNumber}", color = Color.White)
        }
        Icon(imageVector = Icons.Rounded.Delete, contentDescription = "delete contact", tint = Color.White,

            modifier = Modifier.clickable {
                onEvent(ContactsEvents.deleteContact(contacts))
            })

    }
}


