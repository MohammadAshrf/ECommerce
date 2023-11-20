package com.example.ecommerce.ui.home.tabs.wishList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.ItemCategoriesGridBinding
import com.example.ecommerce.databinding.ItemWishListBinding

class WishListAdapter(private val items: List<WishListItem>) :
    RecyclerView.Adapter<WishListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemWishListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WishListItem) {
            binding.productName.text = item.productName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemWishListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}