package com.example.androidcomponents.presentation

import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.androidcomponents.R
import com.example.androidcomponents.data.ForegroundService
import com.example.androidcomponents.data.GetSelectedItemReceiver
import com.example.androidcomponents.databinding.ActivityMainBinding
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

    override fun openDetailsScreen(id: Int) {
        launchFragment(SelectedItemFragment.newInstance(id), true)
    }

    private fun launchFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .also {
                if (addToBackStack) {
                    it.addToBackStack(null)
                }
            }.commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}
