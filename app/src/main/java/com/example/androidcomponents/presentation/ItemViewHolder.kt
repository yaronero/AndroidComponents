package com.example.androidcomponents.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcomponents.R

class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val itemId = view.findViewById<TextView>(R.id.tv_item_id)
    val itemName = view.findViewById<TextView>(R.id.tv_item_name)
}