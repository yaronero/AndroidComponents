package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.domain.Item

data class SelectedItemState(
    val itemId: Int,
    val item: Item?
)