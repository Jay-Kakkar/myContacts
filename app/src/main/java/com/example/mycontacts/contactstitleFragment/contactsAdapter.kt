package com.example.mycontacts.contactstitleFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.databinding.ListBinding
import com.example.mycontacts.formatedContactsData

//class contactsAdapter :
//    ListAdapter<contacts, contactsAdapter.ViewHolder>(ContactsDiffCallbacks()) {
class contactsAdapter : RecyclerView.Adapter<contactsAdapter.ViewHolder>() {

    var data = listOf<contacts>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ViewHolder(var binding: ListBinding) : RecyclerView.ViewHolder(binding.root) {
        val contactsData=binding.textview
        fun bind(item: contacts) {
            contactsData.text =
                formatedContactsData(item.firstName.toString(), item.lastName.toString())

        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    class ContactsDiffCallbacks : DiffUtil.ItemCallback<contacts>() {

        override fun areItemsTheSame(oldItem: contacts, newItem: contacts): Boolean {
            return oldItem.contactsId == newItem.contactsId
        }


        override fun areContentsTheSame(oldItem: contacts, newItem: contacts): Boolean {
            return oldItem == newItem
        }
    }

}

class contactsClickListener(val clickListener: (contactsId: Long) -> Unit) {
    fun onClick(contacts: contacts) = clickListener(contacts.contactsId)

}
