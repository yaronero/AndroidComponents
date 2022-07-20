package com.example.androidcomponents.presentation

import androidx.fragment.app.Fragment

interface MainContractView {

    fun launchFragment(fragment: Fragment, addToBackStack: Boolean = false)
}