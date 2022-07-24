package com.example.androidcomponents.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Action>(
    private val useCases: Set<UseCase<State, Action>>,
    private val reducer: Reducer<State, Action>
) : ViewModel() {

    private val mutableState = MutableLiveData(reducer.initialState)
    private var stateValue: State
        get() = mutableState.value!!
        set(value) {
            mutableState.value = value
        }
    val state: LiveData<State> = mutableState

    fun action(action: Action) {
        stateValue = reducer.reduce(stateValue, action)
        useCases
            .filter { it.canHandle(action) }
            .forEach {
                val result = it.invoke(stateValue, action)
                action(result)
            }
    }
}