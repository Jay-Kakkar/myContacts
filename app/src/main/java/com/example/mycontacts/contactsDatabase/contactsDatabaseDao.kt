package com.example.mycontacts.contactsDatabase

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface contactsDatabaseDao {
    @Insert
    suspend fun insert(contact: contacts)

    @Update
    suspend fun update(contact: contacts)

    @Query("SELECT * FROM contacts_table WHERE contactsId=:key")
    suspend fun get(key: Long): contacts?

    @Query("DELETE FROM contacts_table")
    suspend fun clear()

    @Query("SELECT * FROM contacts_table ORDER BY name0 Asc")
    fun getAllContacts(): LiveData<List<contacts>>

    @Query("SELECT * FROM contacts_table ORDER BY name0 Asc LIMIT 1")
    suspend fun getCurrentContact(): contacts?

    @Query("SELECT * from contacts_table WHERE contactsId = :key")
    fun getContactWithId(key: Long): LiveData<contacts>
}