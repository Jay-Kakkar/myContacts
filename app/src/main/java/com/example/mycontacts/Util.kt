package com.example.mycontacts

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Build

import android.text.Html
import android.text.Spanned
import android.util.Log
import androidx.core.text.HtmlCompat
import com.example.mycontacts.contactsDatabase.contacts
fun convertToString(contacts: String?): String {
    return contacts.toString()
}

fun FormatContacts(contacts: List<contacts>, resources: Resources): Spanned {

    val sb = StringBuilder()
    sb.apply {
        Log.e(this.toString(),"###################3 ${contacts}")

        append(resources.getString(R.string.title))
        contacts.forEach {
            append("<br>")
            append(resources.getString(R.string.first_name))
            append("\t${
                convertToString(it.firstName)}<br>")
            append(resources.getString(R.string.last_name))
            append("\t${
                convertToString(it.lastName)}<br>")
            append(resources.getString(R.string.phone))
            append("\t${it.phone}<br>")
            append(resources.getString(R.string.email))
            append("\t ${it.email}:")

        }
    }
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
    } else {
        return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}