package com.example.mycontacts.contactsEditor

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.databinding.FragmentContactsEditorBinding

class contactsEditor() : Fragment() {

    private lateinit var viewModel: EditorViewModel
    private lateinit var binding: FragmentContactsEditorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application = requireNotNull(this.activity).application
        val dataSource = contactDatabase.getInstance(application).contactsDatabaseDao

        val viewModelFactory = EditorViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EditorViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_editor, container, false)
binding.setLifecycleOwner(this)
        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_Action -> {
                Toast.makeText(
                    requireActivity(),
                    "Deleted",
                    Toast.LENGTH_SHORT
                ).show()
                this.findNavController()
                    .navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
            }
            R.id.action_save -> {
                saveContacts()

            }
        }


        return super.onOptionsItemSelected(item)
    }

    fun saveContacts() {

        var email = binding.email.text.toString()
        var lastName = binding.editLastname.text.toString()
        var firstName = binding.editFirstname.text.toString()
        var phone = binding.editMobile.text.toString()
        if (firstName.isEmpty())
            Toast.makeText(
                requireActivity(),
                "First name should not be empty ",
                Toast.LENGTH_SHORT
            ).show()
        if (phone.isEmpty())
            Toast.makeText(
                requireActivity(),
                "Phone number should not be empty ${firstName}",
                Toast.LENGTH_SHORT
            ).show()
        if (firstName.isNotEmpty() && phone.isNotEmpty()) {
            val newContact=contacts()

            viewModel.insertInDatabase(firstName, lastName, email, phone,newContact)
            Toast.makeText(
                requireActivity(),
                "Saved",
                Toast.LENGTH_SHORT
            ).show()
            this.findNavController()
                .navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_editor, menu)
    }


}