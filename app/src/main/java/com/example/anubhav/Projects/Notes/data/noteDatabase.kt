package com.example.anubhav.Projects.Notes.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Notes::class],
    version = 1
)
abstract class noteDatabase : RoomDatabase(){
    abstract val dao: notesDAO
}