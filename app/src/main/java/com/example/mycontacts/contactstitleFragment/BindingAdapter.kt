package com.example.mycontacts.contactstitleFragment

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.formatedContactsData

@BindingAdapter("First_Name")
fun EditText.setFirstName(item:contacts?) {
    item.let {
        val first: EditText = findViewById(R.id.firstname)

        first.setText("${it?.firstName}")
    }
}
