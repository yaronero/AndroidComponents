package com.example.androidcomponents.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.androidcomponents.domain.Item

object Repository {

    private val list = mutableListOf<Item>()

    private val listLD = MutableLiveData<List<Item>>()

    init {
        for(i in 0..19){
            val item = Item(i, "Name $i", "Description $i")
            list.add(item)
        }
        setItemLiveDataList()
    }

    fun getItemList(): LiveData<List<Item>> {
        return listLD
    }

    fun getItemById(id: Int): Item {
        return list.first { id == it.id }
    }

    private fun setItemLiveDataList(){
        listLD.value = list
    }
}