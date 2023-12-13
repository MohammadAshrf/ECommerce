package com.example.ecommerce.ui.home.tabs.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.category.CategoryResponse
import com.example.domain.entity.subcategory.SubCategoryResponse
import com.example.domain.usecase.GetAppliance
import com.example.domain.usecase.GetCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeApplianceViewModel @Inject constructor(
    private val getApplianceUseCase: GetAppliance
) : ViewModel() {

    private val _appliance: MutableStateFlow<CategoryResponse?> = MutableStateFlow(null)
    val appliance: StateFlow<CategoryResponse?> = _appliance

    fun getAppliance() {
        viewModelScope.launch {
            try {
                _appliance.value = getApplianceUseCase()
            } catch (e: Exception) {
                Log.e("HomeApplianceViewModel", e.message.toString())
            }
        }
    }
}