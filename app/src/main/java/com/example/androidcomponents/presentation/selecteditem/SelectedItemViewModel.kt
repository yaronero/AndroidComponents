package com.example.androidcomponents.presentation.selecteditem

import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item

class SelectedItemViewModel : ViewModel() {

    private val repository = Repository

    fun getItemById(id: Int): Item {
        return repository.getItemById(id)
    }
}