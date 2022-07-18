package com.example.androidcomponents.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, ItemListFragment.newInstance())
                .commit()
        }
    }
}