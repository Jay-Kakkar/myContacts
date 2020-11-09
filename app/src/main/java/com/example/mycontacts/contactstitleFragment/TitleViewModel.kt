package com.example.mycontacts.contactstitleFragment

import androidx.lifecycle.*
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.*

class TitleViewModel :
    ViewModel() {

    private var _currentContact = MutableLiveData<contacts>()
    val currentContact: LiveData<contacts>
        get() = currentContact

//    val contacts = database.getAllContacts()

    private var _navigateToContactsId = MutableLiveData<Long>()
    val navigateToContactsId: LiveData<Long>
        get() = _navigateToContactsId

//    init {
//        initialiseCurrentContact()
//    }



    private var viewModelJob = Job()

//    private fun initialiseCurrentContact() {
//        viewModelScope.launch {
////            _currentContact.value = database.getCurrentContact()
//        }
//    }


//    private suspend fun clear() {
//        withContext(Dispatchers.IO) {
//            database.clear()
//        }
//    }
//
//    private suspend fun update(contacts: contacts) {
//        withContext(Dispatchers.IO) {
//            database.update(contacts)
//        }
//
//    }
//
//    private suspend fun insert(contacts: contacts) {
//        withContext(Dispatchers.IO) {
//            database.insert(contacts)
//        }
//    }
//
//    private suspend fun delete() {
//        withContext(Dispatchers.IO) {
//            database.delete(contacts)
//        }
//    }

    /**
     * This method will be called when this ViewModel is no longer used and will be destroyed.
     *
     *
     * It is useful when ViewModel observes some data and you need to clear this subscription to
     * prevent a leak of this ViewModel.
     */
    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun DeleteAllContacts() {
        viewModelScope.launch {
            // Clear the database table.
//            clear()

            // And clear tonight since it's no longer in the database
            _currentContact.value = null
        }

        // Show a snackbar message, because it's friendly.
    }

    fun onContactsIsClicked(id: Long) {
        _navigateToContactsId.value = id
    }

}