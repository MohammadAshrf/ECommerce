package com.example.ecommerce.ui.home.tabs.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.ecommerce.R
import com.example.ecommerce.databinding.FragmentCategoriesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    private var _viewBinding: FragmentCategoriesBinding? = null
    private lateinit var categoryViewModel: CategoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryViewModel = ViewModelProvider(this)[CategoryViewModel::class.java]
        initViews()
    }

    private val binding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentCategoriesBinding.inflate(inflater, container, false)


//        val categoryListItem = listOf(
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//            CategoryListDemo(R.drawable.req_category_list, "Men's Fashion"),
//        )

        val categoryListAdapter = CategoryListAdapter()
        binding.rvCategoryList.adapter = categoryListAdapter

        val categoryListDemoGridItems = listOf(
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
            CategoryListDemo(R.drawable.category_grid_img, "Suits"),
        )

        val categoryGridItemAdapter = CategoryGridAdapter(categoryListDemoGridItems)
        binding.rvCategoryGrid.adapter = categoryGridItemAdapter

        //category list
        lifecycleScope.launch {
            launch {
                categoryViewModel.categories.collect {
                    Log.e("TAG", "CategoryList: $it")
                    categoryListAdapter.submitList(it)
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryViewModel.getCategories()
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }

    private fun initViews() {
        _viewBinding?.vm = categoryViewModel
        _viewBinding?.lifecycleOwner = this
    }
}