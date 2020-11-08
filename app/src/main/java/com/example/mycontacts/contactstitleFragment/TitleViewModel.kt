package com.example.mycontacts.contactstitleFragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TitleViewModel(val database: contactsDatabaseDao, application: Application) :
    AndroidViewModel(application) {


    private var currentContact = MutableLiveData<contacts>()
    val _currentContact: LiveData<contacts>
        get() = currentContact

    val contacts = database.getAllContacts()
    private var showSnakbarEvent = MutableLiveData<Boolean>()
    val _showSnackBarEvent: LiveData<Boolean>
        get() = showSnakbarEvent

    private var navigateToContactsId = MutableLiveData<Long>()
    val _navigateToContactsId: LiveData<Long>
        get() = navigateToContactsId

    init {
       initialiseCurrentContact()
    }

    private fun initialiseCurrentContact() {
        viewModelScope.launch {
            currentContact.value=database.getCurrentContact()
        }
    }

    private suspend fun clear() {
        withContext(Dispatchers.IO) {
            database.clear()
        }
    }
    private suspend fun update(contacts: contacts){
        withContext(Dispatchers.IO){
            database.update(contacts)
        }

    }
    private suspend fun insert(contacts: contacts){
        withContext(Dispatchers.IO){
            database.insert(contacts)
        }
    }
    private suspend fun delete(){
        withContext(Dispatchers.IO){
            database.delete(contacts)
        }
    }

    fun onContactsIsClicked(id: Long) {
        navigateToContactsId.value = id
    }

}