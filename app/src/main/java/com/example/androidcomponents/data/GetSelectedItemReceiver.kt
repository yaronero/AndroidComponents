package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.androidcomponents.presentation.PREFS_ITEM
import com.example.androidcomponents.presentation.LAST_SELECTED_ITEM_ID

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val sharedPrefs = context?.getSharedPreferences(
            PREFS_ITEM,
            Context.MODE_PRIVATE
        )

        val id =
            sharedPrefs?.getInt(LAST_SELECTED_ITEM_ID, UNDEFINED_ID)

        Log.d("BR_TRIGGER", "GetSelectedItemReceiver: last selected item id is $id")
    }

    companion object {
        private const val UNDEFINED_ID = -1

        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}