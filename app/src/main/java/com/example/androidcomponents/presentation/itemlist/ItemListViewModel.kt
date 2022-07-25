package com.example.androidcomponents.presentation.itemlist

import com.example.androidcomponents.base.BaseViewModel
import com.example.androidcomponents.base.UseCase

class ItemListViewModel(
    useCases: Set<UseCase<ItemListState, ItemListAction>>
) : BaseViewModel<ItemListState, ItemListAction>(
    useCases = useCases,
    reducer = ItemListReducer()
) {

    fun loadList() {
        action(ItemListAction.Load)
    }

    fun putItemIdInPrefs(id: Int) {
        action(ItemListAction.SaveId(id))
    }
}