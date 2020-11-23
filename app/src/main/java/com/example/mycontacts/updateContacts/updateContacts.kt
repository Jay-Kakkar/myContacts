package com.example.mycontacts.updateContacts

import android.annotation.SuppressLint
import android.app.ActionBar
import android.app.ActionBar.DISPLAY_HOME_AS_UP
import android.app.AlertDialog
import android.app.Application
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.NavUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mycontacts.R
import com.example.mycontacts.contactsDatabase.contactDatabase
import com.example.mycontacts.contactsDatabase.contactsDatabaseDao
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
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // in here you can do logic when backPress is clicked
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setMessage("Discard changes")
                alertDialogBuilder.setPositiveButton(
                    "NO",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialogBuilder.setNegativeButton(
                    "YES",
                    DialogInterface.OnClickListener { dialog, which ->
                        findNavController().navigate(updateContactsDirections.actionUpdateContactsToContactsTitleFragment2())
                    })
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }

        })


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
        Log.e(this.toString(), "###########${arguments.contactsKey}")
        val viewModelFactory = updateContactsviewModelFactory(arguments.contactsKey, dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory).get(updateViewModel::class.java)
        viewModel.getData()

        binding = DataBindingUtil.inflate(inflater, R.layout.update, container, false)
        binding.lifecycleOwner = this

        viewModel._first.observe(viewLifecycleOwner, Observer {
            binding.firstname.setText("$it")
        })

        viewModel._last.observe(viewLifecycleOwner, Observer {
            binding.lastname.setText("$it")
        })
        viewModel._phone.observe(viewLifecycleOwner, Observer {
            binding.mobile.setText("$it")
        })
        viewModel._email.observe(viewLifecycleOwner, Observer {
            binding.email.setText("$it")
        })
        binding.firstname.freezesText
        setHasOptionsMenu(true)

        return binding.root
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setMessage("Discard changes")
                alertDialogBuilder.setPositiveButton(
                    "NO",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialogBuilder.setNegativeButton(
                    "YES",
                    DialogInterface.OnClickListener { dialog, which ->
                    })
                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
            R.id.call -> startActivity(
                Intent(
                    Intent.ACTION_DIAL, Uri.fromParts(
                        "tel",
                        viewModel._phone.value, null
                    )
                )
            )

//            R.id.save->updateContactsData()
            R.id.delete -> {
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setMessage("Do you want to delete")
                alertDialogBuilder.setPositiveButton(
                    "NO",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialogBuilder.setNegativeButton(
                    "YES",
                    DialogInterface.OnClickListener { dialog, which ->
                        viewModel.deleteInContacts()

                        findNavController().navigate(updateContactsDirections.actionUpdateContactsToContactsTitleFragment2())
                    })

                val alertDialog: AlertDialog = alertDialogBuilder.create()
                alertDialog.setCancelable(false)
                alertDialog.show()
            }
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