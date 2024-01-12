package com.example.ecommerce.ui.home.tabs.home.category

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
class HomeCategoryViewModel @Inject constructor(
    private val homeCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    private val _homeCategories: MutableStateFlow<List<Category?>?> = MutableStateFlow(null)
    val homeCategories: StateFlow<List<Category?>?> = _homeCategories

    fun getHomeCategories() {
        viewModelScope.launch {
            try {
                _homeCategories.value = homeCategoriesUseCase()
            } catch (e: Exception) {
                Log.e("HomeCategoryViewModel", e.message.toString())
            }
        }
    }
}