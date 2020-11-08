package com.example.mycontacts.contactsEditor

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import com.example.mycontacts.contactsDatabase.contactDatabse
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EditorViewModel(val database: contactsDatabaseDao, application: Application) :
    AndroidViewModel(application) {
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
    private suspend fun delete(contacts: LiveData<List<contacts>>){
        withContext(Dispatchers.IO){
            database.delete(contacts)
        }
    }


}