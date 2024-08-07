package com.example.anubhav.Projects.Notes.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.anubhav.Projects.Notes.data.Notes
import kotlinx.coroutines.flow.Flow

@Dao
interface notesDAO {


    @Upsert
    suspend fun upsert(note: Notes)

    @Delete
    suspend fun delete(note: Notes)

    @Query("SELECT * FROM notes ORDER BY title ASC")
    fun sortByTitle(): Flow<List<Notes>>


    @Query("SELECT * FROM notes ORDER BY dateAdded")
    fun sortByDateAdded(): Flow<List<Notes>>

}