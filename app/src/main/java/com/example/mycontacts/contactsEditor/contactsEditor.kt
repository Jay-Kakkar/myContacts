package com.example.mycontacts.contactsEditor

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabse
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
import com.example.mycontacts.databinding.FragmentContactsEditorBinding
lateinit var firstName: String
lateinit var lastName: String
lateinit var phone: String
lateinit var email: String
class contactsEditor() : Fragment() {
    private lateinit var viewModel: EditorViewModel
    private lateinit var database: contactsDatabaseDao

    private var flag = 0
    private lateinit var binding: FragmentContactsEditorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val application = requireNotNull(this.activity).application

        val dataSource = contactDatabse.getInstance(application)!!.contactsDatabaseDao
        val viewModelFactory = EditorViewModelFactory(dataSource, application)

        viewModel = ViewModelProvider(this, viewModelFactory).get(EditorViewModel::class.java)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_editor, container, false)

     
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
                 email = binding.email.text.toString()
                 lastName = binding.editLastname.text.toString()
                firstName = binding.editFirstname.text.toString()
                phone = binding.editMobile.text.toString()
                if (firstName.isEmpty())
                    Toast.makeText(
                        requireActivity(),
                        "First name should not be empty",
                        Toast.LENGTH_SHORT
                    ).show()
                if (phone.isEmpty())
                    Toast.makeText(
                        requireActivity(),
                        "Phone number should not be empty",
                        Toast.LENGTH_SHORT
                    ).show()
                if (firstName.isNotEmpty() && phone.isNotEmpty()) {
                    viewModel.insertInDatabase()
                    Toast.makeText(
                        requireActivity(),
                        "Saved",
                        Toast.LENGTH_SHORT
                    ).show()
                    this.findNavController()
                        .navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
                }
            }
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_editor, menu)
    }

}