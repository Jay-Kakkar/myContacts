package com.example.mycontacts.contactsEditor

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.databinding.FragmentContactsEditorBinding
import com.example.mycontacts.databinding.FragmentContactsTitleBinding

class contactsEditor : Fragment() {
    private lateinit var binding : FragmentContactsEditorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_editor, container, false)
        setHasOptionsMenu(true)
        return binding.root

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.delete_Action->this.findNavController().navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
            R.id.action_save->this.findNavController().navigate(R.id.action_contactsEditor_to_contactsTitleFragment2)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_editor, menu)
    }
}