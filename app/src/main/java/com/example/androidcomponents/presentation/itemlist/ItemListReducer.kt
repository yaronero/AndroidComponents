package com.example.androidcomponents.presentation.itemlist

import com.example.androidcomponents.base.Reducer

class ItemListReducer : Reducer<ItemListState, ItemListAction> {

    override val initialState = ItemListState(
        emptyList()
    )

    override fun reduce(state: ItemListState, action: ItemListAction): ItemListState {
        return when (action) {
            ItemListAction.None -> state
            ItemListAction.Load -> state
            is ItemListAction.ItemsLoaded -> state.copy(
                list = action.itemList
            )
            is ItemListAction.Error -> state
        }
    }
}