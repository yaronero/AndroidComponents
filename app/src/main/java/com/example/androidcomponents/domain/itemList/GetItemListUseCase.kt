package com.example.androidcomponents.domain.itemList

import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.presentation.itemlist.ItemListAction
import com.example.androidcomponents.presentation.itemlist.ItemListState

class GetItemListUseCase : UseCase<ItemListState, ItemListAction> {

    override fun invoke(state: ItemListState, action: ItemListAction): ItemListAction {
        return if (action is ItemListAction.Load) {
            try {
                ItemListAction.ItemsLoaded(Repository.getItemList())
            } catch (e: Exception) {
                ItemListAction.Error(e)
            }
        } else {
            ItemListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: ItemListAction): Boolean {
        return action is ItemListAction.Load
    }
}