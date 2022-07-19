package com.example.androidcomponents.presentation.itemlist

import androidx.recyclerview.widget.RecyclerView
import com.example.androidcomponents.databinding.ItemBinding
import com.example.androidcomponents.domain.Item

class ItemViewHolder(
    private val binding: ItemBinding,
    private val onItemClickListener: ((Int) -> Unit)
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