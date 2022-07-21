package com.example.androidcomponents.presentation.selecteditem

sealed class SelectedItemEvent {
    class LoadSelectedItemEvent(val id: Int) : SelectedItemEvent()
}