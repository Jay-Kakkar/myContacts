package com.example.mycontacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {
    private var flag = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = this.findNavController(R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController)


//        supportFragmentManager?.addOnBackStackChangedListener (this)


    }

    //
//    override fun onBackStackChanged() {
//        shouldDisplayHomeUp()
//    }
//
//    private fun shouldDisplayHomeUp() {
//        //Enable Up button only  if there are entries in the back stack
//        var canGoBack: Boolean = supportFragmentManager.backStackEntryCount > 0;
//        Log.i(this.toString(), "########################${flag} ###########################")
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//
//    }
//
//
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment);
        return navController.navigateUp()
    }
}