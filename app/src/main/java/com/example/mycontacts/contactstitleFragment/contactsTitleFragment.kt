package com.example.mycontacts.contactstitleFragment

import android.R.attr.phoneNumber
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contacts
import com.example.mycontacts.databinding.FragmentContactsTitleBinding
import com.google.android.material.snackbar.Snackbar


class contactsTitleFragment : Fragment() {

    private lateinit var viewModel: TitleViewModel

    private lateinit var binding: FragmentContactsTitleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val application = requireNotNull(this.activity).application
        val dataSource = contactDatabase.getInstance(application).contactsDatabaseDao

        val viewModelFactory = TitleViewModelFactory(dataSource, application)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(TitleViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =
            inflate(inflater, R.layout.fragment_contacts_title, container, false)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_contactsTitleFragment2_to_contactsEditor)
        }
        //used for live data
        binding.lifecycleOwner = this

        val adapter = contactsAdapter(contactsAdapter.contactsClickListener {
//            val alertDialogBuilder = AlertDialog.Builder(context)
//            alertDialogBuilder.setMessage("Do you want to call or edit")
//            alertDialogBuilder.setPositiveButton(
//                "EDIT",
//                DialogInterface.OnClickListener { dialog, which ->
            this.findNavController()
                .navigate(contactsTitleFragmentDirections.actionContactsTitleFragment2ToUpdateContacts(it))

//                })


//            alertDialogBuilder.setNegativeButton("No") { dialog, which ->
//                startActivity(Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phoneNumber, null)))
//
//                Toast.makeText(context, "clicked No", Toast.LENGTH_LONG).show()
//            }
//            val alertDialog: AlertDialog = alertDialogBuilder.create()
//            alertDialog.setCancelable(false)
//            alertDialog.show()
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()

        })
        binding.recycler.adapter = adapter
        viewModel.current.observe(viewLifecycleOwner, Observer {
            it.let {
//                adapter.data=it
                adapter.submitList(it)
            }

        })
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

