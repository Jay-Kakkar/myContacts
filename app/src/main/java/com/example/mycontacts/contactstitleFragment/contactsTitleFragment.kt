package com.example.mycontacts.contactstitleFragment

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.databinding.FragmentContactsTitleBinding
import com.google.android.material.snackbar.Snackbar


class contactsTitleFragment : Fragment() {

private lateinit var viewModel:TitleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentContactsTitleBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_contacts_title, container, false)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_contactsTitleFragment2_to_contactsEditor)
        }
         viewModel = ViewModelProvider(this)
            .get(TitleViewModel::class.java)

        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.delete_all -> {
                viewModel.DeleteAllContacts()
                Snackbar.make(
                    requireActivity().findViewById(android.R.id.content),
                    "All Contacts are Deleted",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_first, menu)
    }


}

