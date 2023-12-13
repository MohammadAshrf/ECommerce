package com.example.ecommerce.ui.home.tabs.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.category.Data
import com.example.ecommerce.databinding.ItemHomeApplianceGridBinding

class HomeAppGridAdapter :
    ListAdapter<Data, HomeAppGridAdapter.ViewHolder>(CategoryDiffCallBack()) {

    inner class ViewHolder(private val binding: ItemHomeApplianceGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Data) {
            binding.homeApplianceGridText.text = item.name
            Glide.with(binding.root.context).load(item.image).into(binding.homeApplianceIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeApplianceGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoryDiffCallBack : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }
}
//    override fun getItemCount(): Int {
//        return items.size
//    }
