package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.domain.Item

interface SelectedItemContractView {

    fun showItemInfo(item: Item)
}