package com.example.ecommerce.ui.home.tabs.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.ItemHomeApplianceGridBinding

class HomeAppGridAdapter(private val items: List<GridItem>) : RecyclerView.Adapter<HomeAppGridAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemHomeApplianceGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GridItem) {
            binding.homeApplianceGridText.text = item.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHomeApplianceGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}