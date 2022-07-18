package com.example.androidcomponents.presentation

import androidx.lifecycle.ViewModel
import com.example.androidcomponents.data.Repository

class MainViewModel : ViewModel() {

    private val repository = Repository

    val list = repository.getItemList()
}