package com.example.androidcomponents.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.androidcomponents.R
import com.example.androidcomponents.data.ForegroundService
import com.example.androidcomponents.databinding.ActivityMainBinding
import android.content.IntentFilter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.data.GetSelectedItemReceiver
import com.example.androidcomponents.presentation.itemlist.ItemListFragment
import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.UNDEFINED_ID

class MainActivity : AppCompatActivity(), MainContractView {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter by lazy {
        MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        presenter.attachView(this)

        ContextCompat.startForegroundService(this, ForegroundService.newIntent(this))

        val myBroadcastReceiver = GetSelectedItemReceiver()
        val intentFilter = IntentFilter(GetSelectedItemReceiver.ACTION_SHOW_LAST_SELECTED)
        registerReceiver(myBroadcastReceiver, intentFilter)

        val selectedItemId =
            intent?.getIntExtra(GetSelectedItemReceiver.SELECTED_ITEM_ID, UNDEFINED_ID)
                ?: UNDEFINED_ID

        if (savedInstanceState == null) {
            launchFragment(ItemListFragment.newInstance())

            presenter.isIdDefined(selectedItemId)
        }
    }

    override fun launchFragment(fragment: Fragment, addToBackStack: Boolean) {
        if (addToBackStack) {
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

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
