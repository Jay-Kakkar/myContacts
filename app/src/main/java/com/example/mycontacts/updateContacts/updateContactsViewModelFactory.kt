package com.example.mycontacts.updateContacts

import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao

class updateContactsviewModelFactory(val contactsId: Long, val dataSource:contactsDatabaseDao):ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(updateViewModel::class.java)) {
            return updateViewModel(contactsId, dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}