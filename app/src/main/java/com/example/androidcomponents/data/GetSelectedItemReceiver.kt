package com.example.androidcomponents.data

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.androidcomponents.presentation.MainActivity

class GetSelectedItemReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val mainActivityIntent = Intent(context, MainActivity::class.java).apply {
            putExtra(IS_FROM_RECEIVER, true)
        }

        context?.startActivity(mainActivityIntent)
    }

    companion object {
        const val IS_FROM_RECEIVER = "IS_FROM_RECEIVER"

        const val ACTION_SHOW_LAST_SELECTED =
            "com.example.action.androidcomponents.SHOW_LAST_SELECTED"
    }
}