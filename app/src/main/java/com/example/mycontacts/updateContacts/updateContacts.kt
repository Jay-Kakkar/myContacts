package com.example.mycontacts.updateContacts

import android.app.Application
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import androidx.databinding.DataBindingUtil.inflate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.example.mycontacts.databinding.UpdateBinding

class updateContacts : Fragment() {
    private lateinit var application: Application
    private lateinit var dataSource: contactsDatabaseDao
    private lateinit var binding: UpdateBinding
    private lateinit var viewModel: updateViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        application = requireNotNull(this.activity).application
        dataSource = contactDatabase.getInstance(application).contactsDatabaseDao

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.update_changes,menu)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args = updateContactsArgs.fromBundle(requireArguments())
        val viewModelFactory = updateContactsviewModelFactory(args.contactsKey, dataSource)

        viewModel=ViewModelProvider(this,viewModelFactory).get(updateViewModel::class.java)
        binding = inflate(inflater, R.layout.update, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

}