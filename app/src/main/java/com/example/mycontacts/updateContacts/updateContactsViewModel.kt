package com.example.mycontacts.updateContacts

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao

class updateViewModel(contactsKey: Long, dataSource: contactsDatabaseDao) : ViewModel() {
    private val contact = MediatorLiveData<contacts>()

    init {
        contact.addSource(dataSource.getContactWithId(contactsKey), contact::setValue)
    }


}