package com.example.ecommerce.ui.home.tabs.categories.subCategoryGrid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.features.subCategories.model.SubCategory
import com.example.ecommerce.databinding.ItemCategoryGridBinding

class CategoryGridAdapter :
    ListAdapter<SubCategory, CategoryGridAdapter.ViewHolder>(CategoryGridDiffCallBack()) {

    inner class ViewHolder(private val binding: ItemCategoryGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SubCategory) {
            binding.categoryText.text = item.name
//            Glide.with(binding.root.context).load(itemImg.image).into(binding.categoryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoryGridDiffCallBack :
        DiffUtil.ItemCallback<SubCategory>() {
        override fun areItemsTheSame(
            oldItem: SubCategory,
            newItem: SubCategory
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: SubCategory,
            newItem: SubCategory
        ): Boolean {
            return oldItem == newItem
        }
    }

//    override fun getItemCount(): Int {
//        return items.size
//    }
}