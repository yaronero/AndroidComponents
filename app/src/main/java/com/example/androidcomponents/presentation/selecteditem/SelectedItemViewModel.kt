package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.base.BaseViewModel
import com.example.androidcomponents.base.UseCase

class SelectedItemViewModel(
    useCases: Set<UseCase<SelectedItemState, SelectedItemAction>>,
    itemId: Int
) : BaseViewModel<SelectedItemState, SelectedItemAction>(
    useCases = useCases,
    reducer = SelectedItemReducer(itemId)
) {

    fun loadItem() {
        action(SelectedItemAction.Load)
    }
}