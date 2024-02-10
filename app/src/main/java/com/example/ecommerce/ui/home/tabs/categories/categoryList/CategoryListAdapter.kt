package com.example.ecommerce.ui.home.tabs.categories.categoryList

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.features.category.model.Category
import com.example.ecommerce.databinding.ItemCategoryListBinding

class CategoryListAdapter(val onCategoryClickListener: OnCategoryClickListener? = null) :
    ListAdapter<Category, CategoryListAdapter.ViewHolder>
        (CategoryListDiffCallBack()) {

    private var selectedPosition = -1
    private var selectedItemChanged = false

    fun interface OnCategoryClickListener {
        fun onCategoryClick(category: Category)
    }

    inner class ViewHolder(private val binding: ItemCategoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Category) {
            binding.itemCategoryText.text = item.name
            val isSelected = selectedPosition == adapterPosition
            binding.root.setBackgroundColor(if (isSelected) Color.WHITE else Color.TRANSPARENT)
            binding.reqCategoryList.visibility = if (isSelected) View.VISIBLE else View.GONE

            // Handle item click to toggle selected state
            binding.root.setOnClickListener {
                val clickedPosition = adapterPosition
                updateSelection(clickedPosition)

                onCategoryClickListener?.onCategoryClick(item)
                Log.e("tag", "onClick")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
        val category = getItem(position)
//        holder.itemView.tag = category.id

        holder.itemView.setOnClickListener {
            onCategoryClickListener?.onCategoryClick(category)
            selectedItemChanged = true // track selected item change
            val prevSelectedPosition = selectedPosition
            selectedPosition = holder.adapterPosition

            // update background color and rectangle visibility for selected items
            notifyItemChanged(prevSelectedPosition)
            notifyItemChanged(selectedPosition)

        }
    }

    fun updateSelection(selectedPosition: Int) {
        if (selectedItemChanged) {
            selectedItemChanged = false
            notifyDataSetChanged()
        }
    }

    class CategoryListDiffCallBack :
        DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem == newItem
        }
    }
}

/*******Bard Opinion*******/

/**           val isSelected = selectedPosition == adapterPosition
//            itemView.setBackgroundColor(if (isSelected) Color.WHITE else Color.TRANSPARENT)
//            binding.reqCategoryList.visibility =
//                if (isSelected) View.VISIBLE else View.GONE
//
//            itemView.setOnClickListener {
//                selectedItemChanged = true // Track selected item change
//
//                val prevSelectedPosition = selectedPosition
//                selectedPosition = adapterPosition
//
//                // Update background color and rectangle visibility for selected items
//                notifyItemChanged(prevSelectedPosition)
//                notifyItemChanged(selectedPosition)
//                // Update all items if selected item has changed
//                if (selectedItemChanged) {
//                    selectedItemChanged = false // Reset flag
//                    notifyDataSetChanged()
//                }
//        }


CategoryList item click problem (Solved)

//        init {
//            binding.root.setOnClickListener {
//                val clickedPosition = adapterPosition
//                if (selectedPosition != clickedPosition) {
//                    val prevSelectedPosition = selectedPosition
//                    selectedPosition = clickedPosition
//                    notifyItemChanged(prevSelectedPosition)
//                    notifyItemChanged(selectedPosition)
//
//                    val category = getItem(selectedPosition)
//                    onCategoryClickListener?.onCategoryClick(category)
//                }
//            }
//        }
//
//        fun bind(item: Category) {
//            binding.itemCategoryText.text = item.name
//            val isSelected = selectedPosition == adapterPosition
//            binding.root.setBackgroundColor(if (isSelected) Color.WHITE else Color.TRANSPARENT)
//            binding.reqCategoryList.visibility = if (isSelected) View.VISIBLE else View.GONE
//        }
 **/
