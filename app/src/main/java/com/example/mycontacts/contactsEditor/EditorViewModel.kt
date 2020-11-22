package com.example.mycontacts.contactsEditor

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.mycontacts.FormatContacts

import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class EditorViewModel(val databaseDao: contactsDatabaseDao, application: Application) :
    AndroidViewModel(application) {

var current=MutableLiveData<contacts>()

    fun insertInDatabase(
        firstName: String,
        lastName: String,
        email: String,
        phone: String,
        contacts: contacts
    ) {
current.value?.firstName=firstName
        contacts.firstName = firstName
        contacts.lastName = lastName
        contacts.email = email
        contacts.phone = phone

        viewModelScope.launch {
            insert(contacts)
            Log.e(this.toString(),"##################${contacts.phone}")
        }


    }



    private suspend fun insert(contacts: contacts) {
        withContext(Dispatchers.IO) {
            databaseDao.insert(contacts)
        }
    }



}