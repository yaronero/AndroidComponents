package com.example.androidcomponents.data

import com.example.androidcomponents.domain.Item

object Repository {

    private const val ITEM_LIST_SIZE = 20

    private val list by lazy {
        (0 until ITEM_LIST_SIZE)
            .map { Item(it, "Name $it", "Description $it") }
            .toMutableList()
    }

    fun getItemList(): List<Item> {
        return list
    }

    fun getItemById(id: Int): Item {
        return list.first { id == it.id }
    }
}