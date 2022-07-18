package com.example.androidcomponents.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.ItemBinding
import com.example.androidcomponents.domain.Item

class ItemViewHolder(
    private val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item){
        binding.tvItemId.text = item.id.toString()
        binding.tvItemName.text = item.name
    }
}