package com.example.mycontacts

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build

import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import com.example.mycontacts.contactsDatabase.contacts


fun FormatContacts(contacts: List<contacts>): Spanned {

    val sb = StringBuilder()
    sb.apply {
        Log.e(this.toString(),"###################3 ${contacts}")

        contacts.forEach {
            append(it.firstName+" "+it.lastName)
        }
    }
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}