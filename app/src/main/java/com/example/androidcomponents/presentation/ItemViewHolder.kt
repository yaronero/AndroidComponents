package com.example.androidcomponents.presentation

import androidx.recyclerview.widget.RecyclerView
import com.example.androidcomponents.databinding.ItemBinding
import com.example.androidcomponents.domain.Item

class ItemViewHolder(
    private val binding: ItemBinding,
    var onItemClickListener: ((Int) -> Unit)
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: Item) {
        with(binding) {
            tvItemId.text = item.id.toString()
            tvItemName.text = item.name
            root.setOnClickListener {
                onItemClickListener.invoke(item.id)
            }
        }
    }
}