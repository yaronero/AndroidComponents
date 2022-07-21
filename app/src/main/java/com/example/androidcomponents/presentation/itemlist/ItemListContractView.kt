package com.example.androidcomponents.presentation.itemlist

import com.example.androidcomponents.domain.Item

interface ItemListContractView {

    fun showItemList(list: List<Item>)
}