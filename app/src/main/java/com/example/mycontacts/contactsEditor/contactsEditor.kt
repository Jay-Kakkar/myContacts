package com.example.mycontacts.contactsEditor

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.mycontacts.R


class contactsEditor : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts_editor, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_editor,menu)
    }


}