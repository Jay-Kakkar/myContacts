package com.example.mycontacts.contactsEditor

import android.os.Bundle
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.databinding.FragmentContactsEditorBinding
import com.example.mycontacts.databinding.FragmentContactsTitleBinding

class contactsEditor : Fragment() {
    private lateinit var viewModel: EditorViewModel

    private lateinit var binding: FragmentContactsEditorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        viewModel = ViewModelProvider(this).get(EditorViewModel::class.java)
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_editor, container, false)
        var first=binding.editFirstname.toString()

        setHasOptionsMenu(true)
        return binding.root

    }

    fun firstNameEmpty(): Boolean {
        if (viewModel.firstNameEdit.value == null) {

            return false
        }
        return true
    }

    fun phoneNumberEmpty(): Boolean {
        if (!TextUtils.isEmpty(binding.editFirstname.toString())) {

            return false
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_Action -> this.findNavController()
                .navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
            R.id.action_save -> {
//                if (!firstNameEmpty()) {
                    viewModel.firstNameEdit.observe(viewLifecycleOwner, Observer {
                        if (it==null) Toast.makeText(requireContext(),
                            "First name should not be empty",
                            Toast.LENGTH_SHORT)
                            .show()
                    })

//                }
                if (!phoneNumberEmpty()) {
                    Toast.makeText(requireContext(),
                        "First phone number should not be empty",
                        Toast.LENGTH_SHORT).show()
                }
                if (firstNameEmpty() && phoneNumberEmpty()) {
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