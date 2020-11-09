package com.example.mycontacts.contactstitleFragment

import androidx.recyclerview.widget.DiffUtil
import com.example.mycontacts.contactsDatabase.contacts

class contactsAdapter {
}
class ContactsDiffCallbacks:DiffUtil.ItemCallback<contacts>(){

    override fun areItemsTheSame(oldItem: contacts, newItem: contacts): Boolean {
        return oldItem.contactsId==newItem.contactsId
    }


    override fun areContentsTheSame(oldItem: contacts, newItem: contacts): Boolean {
        return oldItem==newItem
    }

}