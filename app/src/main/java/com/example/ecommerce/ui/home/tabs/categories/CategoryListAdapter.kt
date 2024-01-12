package com.example.ecommerce.ui.home.tabs.categories

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.features.category.model.Category
import com.example.ecommerce.databinding.ItemCategoryListBinding

class CategoryListAdapter : ListAdapter<Category, CategoryListAdapter.ViewHolder>
    (CategoryListDiffCallBack()) {

//    private var selectedPosition = -1
//    private var selectedItemChanged = false

    inner class ViewHolder(private val binding: ItemCategoryListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            // Handle item click to toggle selected state
            binding.root.setOnClickListener {
                val clickedPosition = adapterPosition
                updateSelection(clickedPosition)
            }
        }

        fun bind(item: Category) {
            binding.itemCategoryText.text = item.name

            // Set visibility based on the selected state
            binding.reqCategoryList.visibility =
                if (item.name == item.id) View.VISIBLE else View.GONE

            // Update background color for selected item
            val backgroundColor =
                if (item.name == item.id) Color.WHITE else Color.TRANSPARENT
            binding.root.setBackgroundColor(backgroundColor)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCategoryListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

//    override fun getItemCount(): Int {
//        return items.size
//    }

    private fun updateSelection(selectedPosition: Int) {
        for (index in getItem(selectedPosition).id.toString()) {
            val item = getItem(selectedPosition)
            item.id = ((index.code == selectedPosition).toString())
        }
        notifyDataSetChanged()
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
     **/
