package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.d("BR_TRIGGER", "GetSelectedItemReceiver was triggered")
    }

    companion object {
        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}