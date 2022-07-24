package com.example.androidcomponents.data.usecases

import com.example.androidcomponents.base.UseCase
import com.example.androidcomponents.data.Repository
import com.example.androidcomponents.presentation.selecteditem.SelectedItemAction
import com.example.androidcomponents.presentation.selecteditem.SelectedItemState

class GetItemByIdUseCase : UseCase<SelectedItemState, SelectedItemAction> {

    override fun invoke(state: SelectedItemState, action: SelectedItemAction): SelectedItemAction {
        return if(action is SelectedItemAction.Load){
            try {
                SelectedItemAction.ItemLoaded(Repository.getItemById(state.itemId))
            } catch (e: Exception) {
                SelectedItemAction.Error(e)
            }
        } else {
            SelectedItemAction.Error(IllegalArgumentException("Wrong action: $action"))
        }
    }

    override fun canHandle(action: SelectedItemAction): Boolean {
        return action is SelectedItemAction.Load
    }

}