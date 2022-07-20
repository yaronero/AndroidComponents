package com.example.androidcomponents.presentation

import androidx.lifecycle.ViewModel
import com.example.androidcomponents.utils.UNDEFINED_ID

class MainViewModel : ViewModel() {

    fun isIdDefined(id: Int) = id != UNDEFINED_ID
}