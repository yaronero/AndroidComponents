package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.androidcomponents.presentation.MainActivity
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID
import com.example.androidcomponents.utils.PREFS_ITEM
import com.example.androidcomponents.utils.UNDEFINED_ID

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val sharedPrefs = context?.getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)
        val selectedItemId =
            sharedPrefs?.getInt(LAST_SELECTED_ITEM_ID, UNDEFINED_ID) ?: UNDEFINED_ID

        val mainActivityIntent = Intent(context, MainActivity::class.java).apply {
            putExtra(SELECTED_ITEM_ID, selectedItemId)
        }

        context?.startActivity(mainActivityIntent)
    }

    companion object {
        const val SELECTED_ITEM_ID = "SELECTED_ITEM_ID"

        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}