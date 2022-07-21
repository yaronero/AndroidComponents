package com.example.androidcomponents.presentation.selecteditem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.domain.Item

class SelectedItemViewModel : ViewModel() {

    private val repository = Repository

    private val _state = MutableLiveData<SelectedItemState>()
    val state: LiveData<SelectedItemState>
        get() = _state

    fun obtainEvent(event: SelectedItemEvent) {
        when (event) {
            is SelectedItemEvent.LoadSelectedItemEvent -> {
                val item = getItemById(event.id)
                _state.value = SelectedItemState.LoadingSelectedItem(item)
            }
        }
    }

    private fun getItemById(id: Int): Item {
        return repository.getItemById(id)
    }
}