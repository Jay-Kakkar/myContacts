package com.example.mycontacts.contactsDatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface contactsDatabaseDao {
    @Insert
    suspend fun insert(contact: contacts)

    @Update
    suspend fun update(contact: contacts)

    @Query("UPDATE contacts_table SET First_Name =:first,Last_Name = :last,email =:email,phone =:phone WHERE contactsId=:contactsKey")
    suspend fun updateSingalContact(

        first: String,
        last: String,
        email: String,
        phone: String,
        contactsKey: Long
    )

    @Query("SELECT * FROM contacts_table WHERE contactsId=:key")
    suspend fun get(key: Long): contacts?

    @Query("DELETE FROM contacts_table")
    suspend fun clear()

    @Query("SELECT * FROM contacts_table ORDER BY first_name Asc")
    fun getAllContacts(): LiveData<List<contacts>>

//    @Query("SELECT * FROM contacts_table ORDER BY FirstLetter Asc LIMIT 1")
//    suspend fun getCurrentContact(): contacts?

    @Query("SELECT * FROM contacts_table WHERE contactsId = :key")
    fun getContactWithId(key: Long): LiveData<contacts>

    @Delete
    fun delete(contact: contacts): Int

    @Query("DELETE FROM contacts_table WHERE contactsId = :key")
    fun delete(key: Long)

}