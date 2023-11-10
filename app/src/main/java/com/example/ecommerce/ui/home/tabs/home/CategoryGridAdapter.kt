package com.example.ecommerce.ui.home.tabs.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.ItemCategoriesGridBinding

class CategoryGridAdapter(private val items: List<GridItem>) : RecyclerView.Adapter<CategoryGridAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCategoriesGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GridItem) {
            binding.categoryGridText.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCategoriesGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}