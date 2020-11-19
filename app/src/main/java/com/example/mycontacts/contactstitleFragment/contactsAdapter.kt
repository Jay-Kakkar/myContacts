package com.example.mycontacts.contactstitleFragment

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.databinding.FragmentContactsTitleBinding
import com.example.mycontacts.databinding.ListBinding

class contactsAdapter(val clickListener: contactsClickListener) :
    ListAdapter<contacts, contactsAdapter.ViewHolder>(ContactsDiffCallbacks()) {


    class ContactsDiffCallbacks : DiffUtil.ItemCallback<contacts>() {

        override fun areItemsTheSame(oldItem: contacts, newItem: contacts): Boolean {
            return oldItem.contactsId == newItem.contactsId
        }


        override fun areContentsTheSame(oldItem: contacts, newItem: contacts): Boolean {
            return oldItem == newItem
        }
    }

    class ViewHolder(var binding: ListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: contacts, clickListener: contactsClickListener) {
            binding.clickListener = clickListener
            binding.contacts = item
            binding.executePendingBindings()

        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): contactsAdapter.ViewHolder {
        TODO("Not yet implemented")
    }


    override fun onBindViewHolder(holder: contactsAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

class contactsClickListener(val clickListener: (contactsId: Long) -> Unit) {
    fun onClick(contacts: contacts) = clickListener(contacts.contactsId)

}
