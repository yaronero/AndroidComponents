package com.example.androidcomponents.presentation.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.presentation.selecteditem.SelectedItemAction
import com.example.androidcomponents.presentation.selecteditem.SelectedItemState
import com.example.androidcomponents.presentation.selecteditem.SelectedItemViewModel
import java.lang.IllegalStateException

class ItemDetailsViewModelFactory(
    private val useCases: Set<UseCase<SelectedItemState, SelectedItemAction>>,
    private val itemId: Int
) : ViewModelProvider.Factory{

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            SelectedItemViewModel::class.java -> SelectedItemViewModel(useCases, itemId)
            else -> throw IllegalStateException("Unknown viewModel class: $modelClass")
        }
        return viewModel as T
    }
}