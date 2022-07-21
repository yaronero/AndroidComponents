package com.example.androidcomponents.presentation.itemlist

import com.example.androidcomponents.domain.Item

sealed class ItemListState {
    class LoadingItemList(val list: List<Item>) : ItemListState()
}