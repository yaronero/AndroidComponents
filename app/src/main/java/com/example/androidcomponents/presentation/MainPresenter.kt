package com.example.androidcomponents.presentation

import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.UNDEFINED_ID

class MainPresenter {

    private var view: MainContractView? = null

    fun attachView(view: MainContractView) {
        this.view = view
    }

    fun isIdDefined(id: Int) {
        if(id != UNDEFINED_ID){
            view?.launchFragment(SelectedItemFragment.newInstance(id), true)
        }
    }

    fun detachView() {
        view = null
    }
}