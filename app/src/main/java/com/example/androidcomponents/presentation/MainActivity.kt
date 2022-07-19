package com.example.androidcomponents.presentation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidcomponents.R
import com.example.androidcomponents.data.ForegroundService
import com.example.androidcomponents.databinding.ActivityMainBinding

import android.content.IntentFilter
import androidx.fragment.app.Fragment
import com.example.androidcomponents.data.GetSelectedItemReceiver
import com.example.androidcomponents.presentation.itemlist.ItemListFragment
import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID
import com.example.androidcomponents.utils.PREFS_ITEM
import java.lang.reflect.UndeclaredThrowableException

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        ContextCompat.startForegroundService(this, ForegroundService.newIntent(this))

        val myBroadcastReceiver = GetSelectedItemReceiver()
        val intentFilter = IntentFilter(GetSelectedItemReceiver.ACTION_SHOW_LAST_SELECTED)
        registerReceiver(myBroadcastReceiver, intentFilter)

        if (savedInstanceState == null) {
            launchFragment(ItemListFragment.newInstance())
        }

        val isIntentFromReceiver =
            intent.getBooleanExtra(GetSelectedItemReceiver.IS_FROM_RECEIVER, false)

        if (isIntentFromReceiver) {
            startFragmentByReceiver()
        }
    }

    private fun startFragmentByReceiver() {
        val sharedPrefs = getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)
        val selectedItemId =
            sharedPrefs?.getInt(LAST_SELECTED_ITEM_ID, UNDEFINED_ID) ?: UNDEFINED_ID

        if (selectedItemId != UNDEFINED_ID) {
            launchFragment(SelectedItemFragment.newInstance(selectedItemId), true)
        }
    }

    private fun launchFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        if (addToBackStack){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        } else {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
        }
    }

    companion object {
        private const val UNDEFINED_ID = -1
    }
}
