package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID
import com.example.androidcomponents.utils.PREFS_ITEM

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val sharedPrefs = context?.getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)

        val selectedItemId = sharedPrefs?.getInt(LAST_SELECTED_ITEM_ID, UNDEFINED_ID)

        Log.d("BR_TRIGGER", "GetSelectedItemReceiver: last selected item id is $selectedItemId")
    }

    companion object {
        private const val UNDEFINED_ID = -1

        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}