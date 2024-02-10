package com.example.ecommerce.ui.home.tabs.categories

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.ecommerce.databinding.FragmentCategoriesBinding
import com.example.ecommerce.ui.home.tabs.categories.categoryList.CategoryListAdapter
import com.example.ecommerce.ui.home.tabs.categories.subCategoryGrid.CategoryGridAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CategoriesFragment : Fragment() {
    private var _viewBinding: FragmentCategoriesBinding? = null
    private lateinit var categoriesViewModel: CategoriesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoriesViewModel = ViewModelProvider(this)[CategoriesViewModel::class.java]
        initViews()
    }

    private val binding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentCategoriesBinding.inflate(inflater, container, false)

        // category list
        val categoryListAdapter = CategoryListAdapter {
            categoriesViewModel.updateSelectedCategory(it)
            categoriesViewModel.getCategoriesGrid(it.id ?: "")
        }
        binding.rvCategoryList.adapter = categoryListAdapter

        // category grid
        val categoryGridItemAdapter = CategoryGridAdapter()
        binding.rvCategoryGrid.adapter = categoryGridItemAdapter


        lifecycleScope.launch {
            //category list
            launch {
                categoriesViewModel.categoriesList.collect {
                    Log.e("TAG", "CategoryList: $it")
                    categoryListAdapter.submitList(it)
                }
            }
            //category grid
            launch {
                categoriesViewModel.categoriesGrid.collect {
                    Log.e("TAG", "CategoryGrid: $it")
                    categoryGridItemAdapter.submitList(it)
                }
            }
            //category name and cover image on the top
            launch {
                categoriesViewModel.selectedCategoryId.collect { categoryId ->
                    if (categoryId != null) {
                        val selectedCategory =
                            categoriesViewModel.categoriesList.value?.find { it?.id == categoryId }
                        if (selectedCategory != null) {
                            binding.categoryName.text = selectedCategory.name
                            Glide.with(binding.categoryCoverImage).load(selectedCategory.image)
                                .into(binding.categoryCoverImage)
                        }
                    }
                }
            }
            // select the first item on category list
            launch {
                categoriesViewModel.categoriesList.collect { categories ->
                    if (!categories.isNullOrEmpty()) {
                        categories.find { it?.name == "Men's Fashion" }
                            ?.let { categoriesViewModel.updateSelectedCategory(it) }

                        categories.find { it?.name == "Men's Fashion" }?.id?.let {
                            categoriesViewModel.getCategoriesGrid(
                                it
                            )
                        }

                    }
                }
            }
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesViewModel.getCategoriesList()

    }

    private fun initViews() {
        _viewBinding?.vm = categoriesViewModel
        _viewBinding?.lifecycleOwner = this
    }

    override fun onDestroy() {
        super.onDestroy()
        _viewBinding = null
    }
}