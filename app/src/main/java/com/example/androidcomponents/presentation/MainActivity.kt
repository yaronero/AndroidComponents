package com.example.androidcomponents.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidcomponents.R
import com.example.androidcomponents.data.ForegroundService
import com.example.androidcomponents.databinding.ActivityMainBinding

import android.content.IntentFilter
import com.example.androidcomponents.data.GetSelectedItemReceiver
import com.example.androidcomponents.presentation.itemlist.ItemListFragment

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
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ItemListFragment.newInstance())
                .commit()
        }
    }
}
