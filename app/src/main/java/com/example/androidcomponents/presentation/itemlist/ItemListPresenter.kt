package com.example.androidcomponents.presentation.itemlist

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID

class ItemListPresenter(private val sharedPreferences: SharedPreferences) {

    private val repository = Repository

    private var view: ItemListContractView? = null

    fun attachView(view: ItemListContractView) {
        this.view = view
    }

    fun loadItemList(): List<Item>{
        return repository.getItemList()
    }

    fun putItemIdInPrefs(id: Int){

        sharedPreferences.edit {
            putInt(LAST_SELECTED_ITEM_ID, id)
        }
    }

    fun detachView() {
        view = null
    }
}