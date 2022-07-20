package com.example.androidcomponents.presentation.itemlist

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID
import com.example.androidcomponents.utils.PREFS_ITEM

class ItemListViewModel(
    private val sharedPreferences: SharedPreferences
) : ViewModel() {

    private val repository = Repository

    private val _list = MutableLiveData<List<Item>>()
    val list: LiveData<List<Item>>
        get() = _list

    init {
        _list.value = repository.getItemList()
    }

    fun putItemIdInPrefs(id: Int){

        sharedPreferences.edit {
            putInt(LAST_SELECTED_ITEM_ID, id)
        }
    }
}