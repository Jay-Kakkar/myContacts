package com.example.mycontacts.contactstitleFragment

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.formatedContactsData

@BindingAdapter("ContactsList")
fun TextView.setContactsData(item:contacts){
    item.let {
        text= formatedContactsData(it.firstName.toString(),it.lastName.toString())

    }
}

