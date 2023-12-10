package com.example.ecommerce.ui.home.tabs.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentCategoriesBinding
class CategoriesFragment : Fragment() {
    private lateinit var viewBinding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentCategoriesBinding.inflate(inflater, container, false)

        val categoryListItem = listOf(
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
            CategoryItem(R.drawable.req_category_list, "Men's Fashion"),
        )


        val categoryItemAdapter = CategoryListAdapter(categoryListItem)
        viewBinding.rvCategoryList.adapter = categoryItemAdapter


        val categoryGridItem = listOf(
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
            CategoryItem(R.drawable.category_grid_img, "Suits"),
        )

        val categoryGridItemAdapter = CategoryGridAdapter(categoryGridItem)
        viewBinding.rvCategoryGrid.adapter = categoryGridItemAdapter
        return viewBinding.root
    }
}