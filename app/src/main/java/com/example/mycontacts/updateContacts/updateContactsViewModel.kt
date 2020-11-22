package com.example.mycontacts.updateContacts

import android.util.Log
import androidx.lifecycle.*
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import kotlinx.coroutines.*

class updateViewModel(
    private val contactsKey: Long=0L,
    val dataSource: contactsDatabaseDao,
) : ViewModel() {

    private var viewModelJob = Job()

//    private var firstName = MutableLiveData<String>()
//    val _firstName: LiveData<String>
//        get() = firstName
//    var lastName: String? = null
//    var phone: String? = null
//    var email: String? = null

    private val currentContact = dataSource.getContactWithId(contactsKey)

    private val contact = MediatorLiveData<contacts>()
    fun getContact() = contact

    init {
        contact.addSource(dataSource.getContactWithId(contactsKey), contact::setValue)
        Log.e(this.toString(),"^^^^^^^^^^^^^^$contact")
    }

    suspend fun update(contacts: contacts) {
        withContext(Dispatchers.IO) {
            dataSource.update(contacts)
        }
    }fun s(){

    }

    suspend fun get(){
        withContext(Dispatchers.IO){
            dataSource.get(contactsKey)
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }




}


