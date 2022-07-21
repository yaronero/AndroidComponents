package com.example.androidcomponents.presentation.itemlist

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID

class ItemListViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val repository = Repository

    private val _list = MutableLiveData<List<Item>>()
    private val list: LiveData<List<Item>>
        get() = _list

    private val _state = MutableLiveData<ItemListState>()
    val state: LiveData<ItemListState>
        get() = _state

    fun obtainEvent(event: ItemListEvent) {
        when (event) {
            is ItemListEvent.LoadItemList -> {
                _list.value = repository.getItemList()
                _state.value = ItemListState.LoadingItemList(list.value!!)
            }
            is ItemListEvent.ClickOnListItem -> {
                putItemIdInPrefs(event.id)
            }
        }
    }

    private fun putItemIdInPrefs(id: Int) {

        sharedPreferences.edit {
            putInt(LAST_SELECTED_ITEM_ID, id)
        }
    }
}