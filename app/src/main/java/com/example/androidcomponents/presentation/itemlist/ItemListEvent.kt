package com.example.androidcomponents.presentation.itemlist

sealed class ItemListEvent {
    object LoadItemList : ItemListEvent()
    class ClickOnListItem(val id: Int) : ItemListEvent()
}