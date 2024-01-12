package com.example.ecommerce.ui.home.tabs.home.woman

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.features.womenProduct.model.WomanProduct
import com.example.domain.features.womenProduct.usecase.GetWomanProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WomanShawlViewModel @Inject constructor(
    private val productsUseCase: GetWomanProductsUseCase,
) : ViewModel() {

    private val _womanShawlProduct: MutableStateFlow<List<WomanProduct?>?> = MutableStateFlow(null)
    val womanShawlProducts: StateFlow<List<WomanProduct?>?> = _womanShawlProduct

    fun getWomanShawlProducts() {
        viewModelScope.launch {
            try {
                _womanShawlProduct.value = productsUseCase()?.filter {
                    it?.category?.name == "Women's Fashion"
                }
            } catch (e: Exception) {
                Log.e("WomanShawlViewModel", e.message.toString())
            }
        }
    }
}