package com.example.ecommerce.ui.home.tabs.categories.categoryDetails

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.category.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryDetailsViewModel @Inject constructor(

) : ViewModel() {

    private val _categoryDetails: MutableStateFlow<List<Category?>?> = MutableStateFlow(null)
    val categoryDetails: StateFlow<List<Category?>?> = _categoryDetails

    fun getCategoryDetails() {
        viewModelScope.launch {
            try {
                //  _categoryDetails.value =
            } catch (e: Exception) {
                Log.e("CategoryDetailsViewModel", e.message.toString())
            }
        }
    }

//    private fun updateData(newValue: List<CategoryListDemo?>?) {
//        _categories.value = newValue
//    }
}
