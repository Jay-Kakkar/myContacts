package com.example.mycontacts.contactsEditor

import android.app.Application
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.room.Database
import com.example.mycontacts.contactsDatabase.contactDatabse
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EditorViewModel() :
    ViewModel() {
    private lateinit var database: contactsDatabaseDao
    private var _firstNameEdit
            = MutableLiveData<String>()
    val firstNameEdit: LiveData<String>
        get() = _firstNameEdit

    private var _lastNameEdit = MutableLiveData<String>()
    val lastNameEdit: LiveData<String>
        get() = _lastNameEdit

    private var _emailEdit = MutableLiveData<String>()
    val emailEdit: LiveData<String>
        get() = _emailEdit
    private var _phoneEdit = MutableLiveData<String>()
    val phoneEdit: LiveData<String>
        get() = _phoneEdit

    suspend fun insertInDatabase(contacts: contacts) {

        contacts.firstName = _firstNameEdit.toString()
        contacts.lastName = _lastNameEdit.toString()
        contacts.email = _emailEdit.toString()
        contacts.phone = _phoneEdit.toString()
        insert(contacts)

    }

    suspend fun updateInDatabase(contacts: contacts, id: Long) {
        contacts.firstName = _firstNameEdit.toString()
        contacts.lastName = _lastNameEdit.toString()
        contacts.email = _emailEdit.toString()
        contacts.phone = _phoneEdit.toString()
        update(contacts, id)

    }


    suspend fun deleteInDatabase(contacts: contacts, id: Long) {
        contacts.firstName = _firstNameEdit.toString()
        contacts.lastName = _lastNameEdit.toString()
        contacts.email = _emailEdit.toString()
        contacts.phone = _phoneEdit.toString()
        delete(contacts, id)
    }

    private suspend fun update(contacts: contacts, id: Long) {
        withContext(Dispatchers.IO) {
            database.update(contacts)
        }

    }

    private suspend fun insert(contacts: contacts) {
        withContext(Dispatchers.IO) {
            database.insert(contacts)
        }
    }

    private suspend fun delete(contacts: contacts, id: Long) {
        withContext(Dispatchers.IO) {
            database.delete(contacts)
        }
    }


}