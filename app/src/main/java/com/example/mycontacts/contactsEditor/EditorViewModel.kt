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

    suspend fun updateInDatabase(contacts: contacts, id: Long) {
//        contacts.firstName = _firstNameEdit.toString()
//        contacts.lastName = _lastNameEdit.toString()
//        contacts.email = _emailEdit.toString()
//        contacts.phone = _phoneEdit.toString()
        update(contacts, id)

    }


    suspend fun deleteInDatabase(contacts: contacts, id: Long) {
//        contacts.firstName = _firstNameEdit.toString()
//        contacts.lastName = _lastNameEdit.toString()
//        contacts.email = _emailEdit.toString()
//        contacts.phone = _phoneEdit.toString()
        delete(contacts, id)
    }

    private suspend fun update(contacts: contacts, id: Long) {
        withContext(Dispatchers.IO) {
            databaseDao.update(contacts)
        }

    }

    private suspend fun insert(contacts: contacts) {
        withContext(Dispatchers.IO) {
            databaseDao.insert(contacts)
        }
    }

    private suspend fun delete(contacts: contacts, id: Long) {
        withContext(Dispatchers.IO) {
            databaseDao.delete(contacts)
        }
    }


}