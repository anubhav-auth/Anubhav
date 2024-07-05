package com.example.anubhav.Projects.Contacts_Manager.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.anubhav.Projects.Contacts_Manager.data.Contacts
import com.example.anubhav.Projects.Contacts_Manager.data.ContactsDAO


@Database(
    entities = [Contacts::class],
    version = 1
)
abstract class ContactsDatabase : RoomDatabase() {
    abstract val dao : ContactsDAO
}