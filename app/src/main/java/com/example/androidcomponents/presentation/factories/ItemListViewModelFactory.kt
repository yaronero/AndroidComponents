package com.example.androidcomponents.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.presentation.itemlist.ItemListAction
import com.example.androidcomponents.presentation.itemlist.ItemListState
import com.example.androidcomponents.presentation.itemlist.ItemListViewModel

class ItemListViewModelFactory(
    private val useCases: Set<UseCase<ItemListState, ItemListAction>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when (modelClass) {
            ItemListViewModel::class.java -> ItemListViewModel(useCases)
            else -> throw IllegalStateException("Unknown viewModel class: $modelClass")
        }
        return viewModel as T
    }
}