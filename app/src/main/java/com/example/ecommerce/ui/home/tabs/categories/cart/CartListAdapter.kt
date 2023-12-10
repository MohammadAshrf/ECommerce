package com.example.ecommerce.ui.home.tabs.categories.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce.databinding.ItemCartListBinding
import com.example.ecommerce.ui.home.tabs.wishList.WishListItem

class CartListAdapter(private val items: List<CartItem>) :
    RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCartListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CartItem) {
            binding.productName.text = item.productName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCartListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}