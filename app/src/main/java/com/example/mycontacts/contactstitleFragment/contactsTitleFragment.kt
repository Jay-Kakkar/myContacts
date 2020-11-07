package com.example.mycontacts.contactstitleFragment

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.databinding.FragmentContactsTitleBinding


class contactsTitleFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentContactsTitleBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_contacts_title,container,false)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_contactsTitleFragment2_to_contactsEditor)
        }
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu_first,menu)
    }


}