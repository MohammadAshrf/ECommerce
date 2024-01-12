package com.example.ecommerce.ui.home.tabs.home.woman

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getString
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.features.womenProduct.model.WomanProduct
import com.example.ecommerce.R
import com.example.ecommerce.databinding.ItemWomanShawlGridBinding

class WomanShawlGridAdapter :
    ListAdapter<WomanProduct, WomanShawlGridAdapter.ViewHolder>(WomanShawlDiffCallBack()) {

    inner class ViewHolder(private val binding: ItemWomanShawlGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: WomanProduct) {
            Glide.with(binding.root.context).load(item.imageCover).into(binding.womanShawlIv)
            binding.womanShawlText.text = item.title
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
            ItemWomanShawlGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class WomanShawlDiffCallBack :
        DiffUtil.ItemCallback<WomanProduct>() {
        override fun areItemsTheSame(
            oldItem: WomanProduct,
            newItem: WomanProduct
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: WomanProduct,
            newItem: WomanProduct
        ): Boolean {
            return oldItem == newItem
        }
    }
}
//    override fun getItemCount(): Int {
//        return items.size
//    }
