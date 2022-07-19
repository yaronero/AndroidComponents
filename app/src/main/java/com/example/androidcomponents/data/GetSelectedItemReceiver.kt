package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.androidcomponents.R

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val sharedPrefs = context?.getSharedPreferences(
            context.getString(R.string.item_prefs),
            Context.MODE_PRIVATE
        )

        val id =
            sharedPrefs?.getInt(context.getString(R.string.last_selected_item_id), UNDEFINED_ID)

        Log.d("BR_TRIGGER", "GetSelectedItemReceiver: last selected item id is $id")
    }

    companion object {
        private const val UNDEFINED_ID = -1

        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}