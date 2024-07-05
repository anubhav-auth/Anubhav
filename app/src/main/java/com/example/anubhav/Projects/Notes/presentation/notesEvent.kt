package com.example.anubhav.Projects.Notes.presentation

import com.example.anubhav.Projects.Notes.data.Notes

sealed interface notesEvent {

    object sortNotes : notesEvent
    data class deleteNote(var note: Notes) : notesEvent
    data class saveNote(
        var title: String,
        var body: String,
    ) : notesEvent


}