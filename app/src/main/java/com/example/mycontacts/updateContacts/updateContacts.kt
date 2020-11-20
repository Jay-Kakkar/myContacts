package com.example.mycontacts.updateContacts

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import androidx.databinding.DataBindingUtil.inflate
import com.example.mycontacts.databinding.UpdateBinding

class updateContacts : Fragment() {
    private lateinit var application: Application
    private lateinit var dataSource: contactsDatabaseDao
    private lateinit var binding:UpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = requireNotNull(this.activity).application
        dataSource = contactDatabase.getInstance(application).contactsDatabaseDao

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=inflate(inflater, R.layout.update,container,false)
        return binding.root
    }
}