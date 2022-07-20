package com.example.androidcomponents.presentation.selecteditem

import com.example.androidcomponents.data.Repository

class SelectedItemPresenter {
    private val repository = Repository

    private var view: SelectedItemContractView? = null

    fun attachView(view: SelectedItemContractView) {
        this.view = view
    }

    fun getItemById(id: Int){
        view?.showItemInfo(repository.getItemById(id))
    }

    fun detachView() {
        view = null
    }
}