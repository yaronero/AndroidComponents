package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.domain.Item

sealed class SelectedItemAction {
    object None : SelectedItemAction()
    object Load : SelectedItemAction()
    class ItemLoaded(val item: Item) : SelectedItemAction()
    class Error(val error: Exception) : SelectedItemAction()
}