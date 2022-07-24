package com.example.androidcomponents.presentation.factories

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.presentation.itemlist.ItemListViewModel
import java.lang.IllegalStateException

class SharedPrefsViewModelFactory(
    private val sharedPreferences: SharedPreferences
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            ItemListViewModel::class.java -> ItemListViewModel(sharedPreferences)
            else -> throw IllegalStateException("Unknown viewModel class: $modelClass")
        }
        return viewModel as T
    }
}