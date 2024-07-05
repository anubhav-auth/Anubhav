package com.example.anubhav.Projects.Contacts_Manager.presentation

import com.example.anubhav.Projects.Contacts_Manager.data.Contacts

data class ContactState(
    val contacts: List<Contacts> = emptyList(),
    val firstName: String = "",
    val lastName: String = "",
    val phoneNumber: String = "",
    val email: String = "",
    val isAddingContact: Boolean = false,
    val sortType: SortType = SortType.FIRST_NAME
)