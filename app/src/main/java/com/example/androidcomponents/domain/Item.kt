package com.example.androidcomponents.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val id: Int,
    val name: String,
    val description: String
) : Parcelable