package com.example.mycontacts.contactsDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts_Table")
data class contacts(
    @PrimaryKey(autoGenerate = true)
    var contactsId: Long = 0L,
    @ColumnInfo(name = "First_Name")
    var firstName: String? = null,
    @ColumnInfo(name = "Last_Name")
    var lastName: String? = null,
    @ColumnInfo(name = "Phone")
    var phone: String? = null,
    @ColumnInfo(name = "Email")
    var email:String?=null,

    var name0: Char? = firstName?.get(0)
)