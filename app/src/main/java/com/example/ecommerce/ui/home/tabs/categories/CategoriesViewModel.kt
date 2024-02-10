package com.example.ecommerce.ui.home.tabs.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.category.model.Category
import com.example.domain.features.category.usecase.GetCategoriesUseCase
import com.example.domain.features.subCategories.model.SubCategory
import com.example.domain.features.subCategories.usecase.GetSubCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getSubCategoryUseCase: GetSubCategoryUseCase
) : ViewModel() {


    private val _categoriesList: MutableStateFlow<List<Category?>?> = MutableStateFlow(emptyList())
    val categoriesList: StateFlow<List<Category?>?> = _categoriesList

    private val _categoriesGrid: MutableStateFlow<List<SubCategory?>?> =
        MutableStateFlow(emptyList())
    val categoriesGrid: StateFlow<List<SubCategory?>?> = _categoriesGrid

    private val _selectedCategoryId: MutableStateFlow<String?> = MutableStateFlow(null)
    val selectedCategoryId: StateFlow<String?> = _selectedCategoryId

    val selectedCategoryName: MutableStateFlow<String?> = MutableStateFlow(null)

    val selectedCategoryImage: MutableStateFlow<String?> = MutableStateFlow(null)

    val itemList: Flow<List<SubCategory?>?> = selectedCategoryId.flatMapLatest { categoryId ->
        flow {
            if (categoryId != null) {
                val subCategories = getSubCategoryUseCase(categoryId)
                emit(subCategories)
            }
        }
    }

    fun updateSelectedCategory(category: Category) {
        _selectedCategoryId.value = category.id
    }

    fun getCategoriesList() {
        viewModelScope.launch {
            try {
                val categories = getCategoriesUseCase()
                _categoriesList.value = categories

            } catch (e: Exception) {
                Log.e("CategoriesList", e.message.toString())
            }
        }
    }

    fun getCategoriesGrid(categoryId: String) {
        viewModelScope.launch {
            try {
                val gridData = getSubCategoryUseCase(categoryId)
                _categoriesGrid.value = gridData
            } catch (e: Exception) {
                Log.e("CategoryGrid", e.message.toString())
            }
        }
    }
}
