package com.example.ecommerce.ui.home.tabs.categories

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.category.model.Category
import com.example.domain.features.category.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _categories: MutableStateFlow<List<Category?>?> = MutableStateFlow(null)
    val categories: StateFlow<List<Category?>?> = _categories

    fun getCategories() {
        viewModelScope.launch {
            try {
                _categories.value = getCategoriesUseCase()
            } catch (e: Exception) {
                Log.e("CategoryViewModel", e.message.toString())
            }
        }
    }

    private fun updateData(newValue: List<Category?>?) {
        _categories.value = newValue
    }
}