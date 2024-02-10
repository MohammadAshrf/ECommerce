package com.example.ecommerce.ui.home.tabs.home.electronics

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.features.product.model.Product
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ItemElectronicsGridBinding

class ElectronicsGridAdapter :
    ListAdapter<Product, ElectronicsGridAdapter.ViewHolder>(ElectronicsDiffCallBack()) {

    inner class ViewHolder(private val binding: ItemElectronicsGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Product) {
            Glide.with(binding.root.context).load(item.imageCover).into(binding.electronicsIv)
            binding.electronicsText.text = item.title
            binding.productPrice.text =
                (getString(binding.root.context, R.string.egp) + " " + item.price.toString())
            binding.productReviewText.text =
                (getString(
                    binding.root.context,
                    R.string.review
                ) + " (" + item.ratingsAverage.toString() + ")")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemElectronicsGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ElectronicsDiffCallBack :
        DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean {
            return oldItem == newItem
        }
    }
}
//    override fun getItemCount(): Int {
//        return items.size
//    }
