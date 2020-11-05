package com.example.mycontacts.contactstitleFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
            this.findNavController().navigate(R.id.action_contactsTitleFragment2_to_contactsEditor)
        }
        return binding.root
    }


}