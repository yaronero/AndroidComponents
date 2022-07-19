package com.example.androidcomponents.presentation.itemlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item

class MainViewModel : ViewModel() {

    private val repository = Repository

    private val _list = MutableLiveData<List<Item>>()
    val list: LiveData<List<Item>>
        get() = _list

    init {
        _list.value = repository.getItemList()
    }
}