package com.example.androidcomponents.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var adapter: ItemListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupItemAdapter()
    }

    private fun setupItemAdapter(){
        adapter = ItemListAdapter(this, viewModel.list.value!!)
        binding.rvItemList.adapter = adapter

        adapter.onItemClickListener = {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, SelectedItemFragment.newInstance(this, it))
                .addToBackStack(null)
                .commit()
        }
    }
}