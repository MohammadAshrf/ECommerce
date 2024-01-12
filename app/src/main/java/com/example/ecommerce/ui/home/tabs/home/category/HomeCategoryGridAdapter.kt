package com.example.ecommerce.ui.home.tabs.home.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.features.category.model.Category
import com.example.ecommerce.databinding.ItemCategoriesGridBinding

class HomeCategoryGridAdapter :
    ListAdapter<Category, HomeCategoryGridAdapter.ViewHolder>(CategoryDiffCallBack()) {

    inner class ViewHolder(private val binding: ItemCategoriesGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Category) {
            binding.categoryGridText.text = item.name
            Glide.with(binding.root.context).load(item.image).into(binding.categoryIv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoriesGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoryDiffCallBack : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }


    }
}

//    override fun getItemCount(): Int {
//        return items.size
//    }
