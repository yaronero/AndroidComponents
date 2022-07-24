package com.example.androidcomponents.base

interface UseCase<State, Action> {

    operator fun invoke(state: State, action: Action): Action

    fun canHandle(action: Action): Boolean
}