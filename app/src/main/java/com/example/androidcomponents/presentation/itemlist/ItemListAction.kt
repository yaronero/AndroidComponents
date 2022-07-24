package com.example.androidcomponents.presentation.itemlist

import com.example.androidcomponents.domain.Item

sealed class ItemListAction {
    object None : ItemListAction()
    object Load : ItemListAction()
    class ItemsLoaded(val itemList: List<Item>) : ItemListAction()
    class Error(val error: Exception) : ItemListAction()
}