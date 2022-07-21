package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.domain.Item

sealed class SelectedItemState {
    class LoadingSelectedItem(val item: Item) : SelectedItemState()
}