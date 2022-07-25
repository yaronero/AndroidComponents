package com.example.androidcomponents.domain.itemList

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.presentation.itemlist.ItemListAction
import com.example.androidcomponents.presentation.itemlist.ItemListState
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID

class PutIdInPrefsUseCase(
    private val sharedPreferences: SharedPreferences
) : UseCase<ItemListState, ItemListAction> {

    override fun invoke(state: ItemListState, action: ItemListAction): ItemListAction {
        return if (action is ItemListAction.SaveId) {
            try {
                sharedPreferences.edit {
                    putInt(LAST_SELECTED_ITEM_ID, action.id)
                }
                ItemListAction.IdSaved
            } catch (e: Exception) {
                ItemListAction.Error(e)
            }
        } else {
            ItemListAction.Error(IllegalArgumentException("Wrong action: $action"))
        }

    }

    override fun canHandle(action: ItemListAction): Boolean {
        return action is ItemListAction.SaveId
    }
}