package com.example.mycontacts.updateContacts

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer

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
        inflater.inflate(R.menu.update_changes, menu)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val arguments = updateContactsArgs.fromBundle(arguments!!)
//Log.e(this.toString(),"###########${arguments.contactsKey}")
        val viewModelFactory = updateContactsviewModelFactory(arguments.contactsKey, dataSource)

        viewModel = ViewModelProvider(this, viewModelFactory).get(updateViewModel::class.java)
        binding= DataBindingUtil.inflate(inflater,R.layout.update,container,false)
        binding.setLifecycleOwner(this)
        binding.firstname.text
        setHasOptionsMenu(true)
        return binding.root
    }

    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to [Activity.onStart] of the containing
     * Activity's lifecycle.
     */
    override fun onStart() {
        super.onStart()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
//            R.id.save->updateContactsData()
        }
        return super.onOptionsItemSelected(item)

    }

    private fun updateContactsData() {
        var firstName = binding.firstname.text.toString()
        var lastName = binding.lastname.text.toString()
        var email = binding.email.text.toString()
        var phone = binding.mobile.text.toString()
        if (firstName.isNotEmpty())
            Toast.makeText(context, "first name cannot be empty", Toast.LENGTH_SHORT).show()
        if (phone.isNotEmpty())
            Toast.makeText(context, "phone number can't be empty", Toast.LENGTH_SHORT).show()
        if (firstName.isNotEmpty() && phone.isNotEmpty()) {
//            viewModel.updateInDatabase(firstName,lastName,phone,email)
        }
    }

}