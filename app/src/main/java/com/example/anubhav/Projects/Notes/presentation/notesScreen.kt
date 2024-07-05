package com.example.anubhav.Projects.Notes.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Sort
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.anubhav.ui.theme.Pink80



@Composable
fun NotesScreen(
    navController: NavController, state: noteState, onEvent: (notesEvent) -> Unit

) {
    Scaffold(modifier = Modifier.padding(top = 12.dp).background(Color.Black), topBar = {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(Pink80)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Notes App",
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            IconButton(onClick = {
                onEvent(
                    notesEvent.sortNotes
                )
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.Sort,
                    contentDescription = null,
                    modifier = Modifier.size(21.dp),
                    tint = Color.Black
                )
            }
        }
    },

        floatingActionButton = {
            FloatingActionButton(containerColor = Pink80, onClick = {
                state.title.value = ""
                state.body.value = ""
                navController.navigate(
                    "add_notes_screen"
                )
            }) {
                Icon(imageVector = Icons.Rounded.Add, contentDescription = "add note")
            }
        }) { paddingValue ->
        LazyColumn(
            contentPadding = paddingValue,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(state.notes.size) {
                NoteItem(
                    state = state, index = it, onEvent = onEvent
                )
            }
        }
    }

}

@Composable
fun NoteItem(state: noteState, index: Int, onEvent: (notesEvent) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Pink80)
            .padding(12.dp)
    ) {

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = state.notes.get(index = index).title,
//                fontSize = 18.dp,
                fontWeight = FontWeight.SemiBold, color = Color.White
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.notes.get(index = index).body,
//                fontSize = 16.dp,
                color = Color.White
            )
        }

        Icon(imageVector = Icons.Rounded.Delete,
            contentDescription = "delete note",
            modifier = Modifier
                .size(35.dp)
                .clickable {
                    onEvent(
                        notesEvent.deleteNote(state.notes[index])
                    )
                })

    }
}
