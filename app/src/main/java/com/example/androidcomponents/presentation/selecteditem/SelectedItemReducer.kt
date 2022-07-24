package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.base.Reducer

class SelectedItemReducer(itemId: Int) : Reducer<SelectedItemState, SelectedItemAction> {

    override val initialState = SelectedItemState(
        itemId = itemId,
        item = null
    )

    override fun reduce(state: SelectedItemState, action: SelectedItemAction): SelectedItemState {
        return when(action) {
            SelectedItemAction.None -> state
            SelectedItemAction.Load -> state
            is SelectedItemAction.ItemLoaded -> state.copy(
                itemId = state.itemId,
                item = action.item
            )
            is SelectedItemAction.Error -> state
        }
    }
}