package com.example.androidcomponents.presentation.itemlist

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.androidcomponents.base.BaseViewModel
import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID

class ItemListViewModel(
    useCases: Set<UseCase<ItemListState, ItemListAction>>,
    private val sharedPreferences: SharedPreferences
) : BaseViewModel<ItemListState, ItemListAction>(
    useCases = useCases,
    reducer = ItemListReducer()
) {

    fun loadList() {
        action(ItemListAction.Load)
    }

    fun putItemIdInPrefs(id: Int) {

        sharedPreferences.edit {
            putInt(LAST_SELECTED_ITEM_ID, id)
        }
    }
}