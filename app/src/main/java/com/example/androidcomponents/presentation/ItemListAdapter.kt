package com.example.androidcomponents.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcomponents.R
import com.example.androidcomponents.domain.Item

class ItemListAdapter(
    private val context: Context,
    private val list: List<Item>
    ) : RecyclerView.Adapter<ItemViewHolder>() {

    var onItemClickListener: ((Item) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]
        holder.itemId.text = context.getString(R.string.item_id, item.id.toString())
        holder.itemName.text = item.name

        holder.itemView.setOnClickListener {
            onItemClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}