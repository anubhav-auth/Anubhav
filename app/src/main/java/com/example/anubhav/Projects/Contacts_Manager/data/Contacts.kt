package com.example.anubhav.Projects.Contacts_Manager.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contacts(

    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String
)
